package player;

public class Player {
    private String playerName;
    private char symbol;
    // private char playerSymbol;
    private String address;
    private long contactNumber;
    private String emailId;
    private int age;

    public void setPlayerDetails(String playername,char symbol,String address,long contactNumber,String emailId, int age) {
        this.playerName = playername;
        this.symbol = symbol;
        this.address = address;
        this.contactNumber = contactNumber;
        this.emailId = emailId;
        this.age = age;
    }

    public void setPlayerNameAndAge(String name, int age) {
        this.playerName = name;
        this.age = age;
    }

    public void setPlayerNameSymbolEmailAge(String playername,char symbol,String emailId, int age) {
        this.playerName = playername;
        this.symbol = symbol;
        this.emailId = emailId;
        this.age = age;
    }

    public void changeSymbol(char symbol) {
        this.symbol = symbol;
    }

    public void setPlayerNameAndSymobl(String playername,char symbol) {
        this.playerName = playername;
        this.symbol = symbol;
    }

    public String getPlayerName() {
        return this.playerName;
    }

    public char getPlayerSymbol() {
        return this.symbol;
    }

    public void getPlayerNameAndSymbol() {
        System.out.println("Player Name: " + this.playerName);
        System.out.println("Player Symbol: " + this.symbol);
    }

    public void getPlayerNameAndAge() {
        System.out.println("Player Name: " + this.playerName);
        System.out.println("Player Age: " + this.age);
    }

    public void getPlayerDetails() {
        System.out.println("Player Name : " + this.playerName);
        System.out.println("Player symbol : " + this.symbol);
        System.out.println("Player EmailId: " + this.emailId);
        System.out.println("Player Age: " + this.age);
        System.out.println("Player Contact Number: " + this.contactNumber);
        System.out.println("Player Address: " + this.address);
    }
}
