import java.io.FileNotFoundException;
import java.io.PrintWriter;

public interface IManager {
    void store(String data) throws FileNotFoundException;
}

public class RelationalManager implements IManager{

    public RelationalManager() {}

    // Would normally use the table_store method from the Relational database system, but is replaced with placeholder
    // code which stores the provided data in a .txt file called 'RelationalOutput.txt'
    public void store(String data) throws FileNotFoundException {
        System.out.println("Storing the provided data, '" + data + ",' using the Relational Manager");
        PrintWriter out = new PrintWriter("RelationalOutput.txt");
        out.println(data);
        out.close();
    }
}

public class NoSQLManager implements IManager {

    public NoSQLManager() {}

    // Would normally use the document_store method from NoSQL, but is replaced with placeholder code which stores the
    // provided data in a .txt file called 'NoSQLOutput.txt'
    public void store(String data) throws FileNotFoundException {
        System.out.println("Storing the provided data, '" + data + ",'  using the NoSQL Manager");
        PrintWriter out = new PrintWriter("NoSQLOutput.txt");
        out.println(data);
        out.close();
    }
}

public class GraphManager implements IManager{

    public GraphManager() {}

    // Would normally use the node_store method from the Graph database system, but is replaced with placeholder
    // code which stores the provided data in a .txt file called 'GraphOutput.txt'
    public void store(String data) throws FileNotFoundException{
        System.out.println("Storing the provided data, '" + data + ",' using the Graph Manager");
        PrintWriter out = new PrintWriter("GraphOutput.txt");
        out.println(data);
        out.close();
    }
}

public class Client {

    private IManager storeStrategy;

    public Client() {
        this.storeStrategy = new RelationalManager();
    }

    public void setStoreStrategy(IManager storeStrategy) {
        this.storeStrategy = storeStrategy;
    }

    public void store(String data) {
        try {
            this.storeStrategy.store(data);
        } catch (FileNotFoundException e) {
            System.out.println("File 'output.txt' cannot be found!");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("\n-------------------------------------------------------------------------------------\n" +
                           "Creating client with default (Relational) database manager...");
        Client client = new Client();
        client.store("Default Test Data");
        System.out.println();

        System.out.println("Changing the client's storage strategy to NoSQLManager...");
        client.setStoreStrategy(new NoSQLManager());
        client.store("NoSQL Test Data");
        System.out.println();

        System.out.println("Changing the client's storage strategy to GraphManager...");
        client.setStoreStrategy(new GraphManager());
        client.store("Graph Test Data");
        System.out.println("-------------------------------------------------------------------------------------\n");
    }
}