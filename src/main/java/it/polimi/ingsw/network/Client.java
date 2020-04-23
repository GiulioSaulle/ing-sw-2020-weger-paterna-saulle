package it.polimi.ingsw.network;

import it.polimi.ingsw.commons.ClientMessage;
import it.polimi.ingsw.commons.ServerMessage;
import it.polimi.ingsw.commons.SnapCell;
import it.polimi.ingsw.commons.SnapWorker;
import it.polimi.ingsw.commons.serverMessages.BuiltServer;
import it.polimi.ingsw.commons.serverMessages.MovedServer;
import it.polimi.ingsw.view.CLI;
import it.polimi.ingsw.view.SnapPlayer;
import it.polimi.ingsw.view.TextFormatting;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Client implements Runnable{

    private CLI view;
    private Socket socket;
    ObjectInputStream in;
    ObjectOutputStream out;
    String username;
    protected ArrayList<SnapCell> board;
    protected ArrayList<SnapWorker> workers;
    protected ArrayList<SnapPlayer> players;

    private static final BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

    String ip;
    int port;

    public Client(){
        this.board = new ArrayList<>();
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++)
                board.add(new SnapCell(i,j,0));
        }
        this.workers=new ArrayList<>();
        this.players = new ArrayList<>();
    }

    public ArrayList<SnapPlayer> getPlayers(){ return players; }

    public CLI getView() {
        return view;
    }

    public void setView(CLI view) {
        this.view = view;
    }

    public ArrayList<SnapCell> getBoard() {
        return board;
    }

    public ArrayList<SnapWorker> getWorkers() {
        return workers;
    }

    public void setIp(String ip){
        this.ip = ip;
    }

    public void setPort(int port){
        this.port=port;
    }

    public String getUsername(){ return this.username; }

    public void setUsername(String username){ this.username=username; }

    public SnapPlayer getMyPlayer(){
        for(SnapPlayer sp : getPlayers())
            if(sp.name.equals(getUsername()))
                return sp;
        return null;
    }

    public void removeWorkers(ArrayList<SnapWorker> snapWorkers){
        for(SnapWorker sw : snapWorkers)
            this.workers.remove(sw);
    }

    public void setPlayers(ArrayList<String> names){
        try{
            this.players = new ArrayList<>();
            for (String name : names) {
                this.players.add(new SnapPlayer(name));
            }
        }catch (Exception e){
            System.exit(-1);
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        Client client = new Client();
        readParams(client);
        String version;
        boolean go;
        do{
            printTitle();

            System.out.print(TextFormatting.RESET + "Choose the version [CLI/GUI] " + TextFormatting.input());
            System.out.flush();

            //read.reset();
            //read.readLine(); //to solve a bug where message after popped too soon

            version = read.readLine();

            go = false;

            if(version.equalsIgnoreCase("CLI")){
                CLI view = new CLI(client);
                client.setView(view);
                view.displayFirstWindow();
            }
            else if(version.equalsIgnoreCase("GUI")){
                // TODO run gui
                System.out.println("RUN GUI...");
                System.out.flush();
            }
            else go = true;
        }while(go);
    }

    public static void readParams(Client client){
        try (FileReader reader = new FileReader("resources"+File.separator+"config.json"))
        {
            // json read
            JSONParser jsonParser = new JSONParser();
            JSONObject config;

            //Read JSON file
            Object obj = jsonParser.parse(reader);
            config = (JSONObject) obj;

            if(config != null){
                if (config.containsKey("port"))
                    client.setPort(Integer.parseInt(config.get("port").toString()));
                if (config.containsKey("ip"))
                    client.setIp(config.get("ip").toString());
            }
        } catch (Exception e) {
            // default params
            client.setPort(1234);
            client.setIp("127.0.0.1");
        }
    }

    public boolean connect() {
        try {
            socket = new Socket(ip,port);
            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());

            ExecutorService executor = Executors.newCachedThreadPool();
            executor.submit(this);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    @Override
    public void run() {
        try {
            while (socket.isConnected() && in != null) {
                ServerMessage msg = (ServerMessage) in.readObject();
                System.out.println(msg.toString());
                System.out.flush();
                if(msg instanceof MovedServer){
                    for(SnapWorker worker : getWorkers()){
                        if(worker.name.equals(((MovedServer) msg).sw.name) && worker.n == ((MovedServer) msg).sw.n){
                            worker.row = ((MovedServer) msg).sw.row;
                            worker.column = ((MovedServer) msg).sw.column;
                        }
                    }
                }else if(msg instanceof BuiltServer){
                    for(SnapCell cell : getBoard()){
                        if(cell.toString().equals(((BuiltServer) msg).sc.toString())){
                            cell.level = ((BuiltServer) msg).sc.level;
                        }
                    }
                }
                msg.accept(view);
            }
        }
        catch (IOException | ClassNotFoundException e){
            System.exit(0);
        }
    }

    public void sendMessage(ClientMessage msg){
        try {
            out.reset();
            out.writeObject(msg);
            out.flush();
        } catch (IOException e) {
            System.out.println("SERVER UNAVAILABLE...");
            System.out.flush();
            System.exit(0);
        }
    }

    public static void printTitle() throws InterruptedException {
        String str =
                " __          ________ _      _____ ____  __  __ ______   _______ ____  \n" +
                        " \\ \\        / /  ____| |    / ____/ __ \\|  \\/  |  ____| |__   __/ __ \\ \n" +
                        "  \\ \\  /\\  / /| |__  | |   | |   | |  | | \\  / | |__       | | | |  | |\n" +
                        "   \\ \\/  \\/ / |  __| | |   | |   | |  | | |\\/| |  __|      | | | |  | |\n" +
                        "    \\  /\\  /  | |____| |___| |___| |__| | |  | | |____     | | | |__| |\n" +
                        "     \\/  \\/   |______|______\\_____\\____/|_|  |_|______|    |_|  \\____/\n\n";
        System.out.println(str);
        System.out.flush();
        TimeUnit.MILLISECONDS.sleep(1200);
        str =
                "   _____         _   _ _______ ____  _____  _____ _   _ _____ \n" +
                        "  / ____|  /\\   | \\ | |__   __/ __ \\|  __ \\|_   _| \\ | |_   _|\n" +
                        " | (___   /  \\  |  \\| |  | | | |  | | |__) | | | |  \\| | | |  \n" +
                        "  \\___ \\ / /\\ \\ | . ` |  | | | |  | |  _  /  | | | . ` | | |  \n" +
                        "  ____) / ____ \\| |\\  |  | | | |__| | | \\ \\ _| |_| |\\  |_| |_ \n" +
                        " |_____/_/    \\_\\_| \\_|  |_|  \\____/|_|  \\_\\_____|_| \\_|_____|\n\n";
        System.out.println(str);
        System.out.flush();
        TimeUnit.MILLISECONDS.sleep(1200);
    }
}
