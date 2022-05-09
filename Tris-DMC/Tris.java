import java.util.*;

public class Tris {

    private int[] ArrMoves = new int[9];
    private boolean flag = true;
    private boolean control = true; // vittoria
    private int MovesCounter = 0;// contatore caselle
    private int value = 0;

    private static String SeqMoves = "";
    private static String result = "";

    Database database = new Database();
    Scanner Input = new Scanner(System.in);

    public Tris() {

    }

    public void InsertMove(int playerID) {

        flag = true;

        if (playerID == 1){
            System.out.print("Player " + playerID + " inserire la casella: ");

            try{

                value = Input.nextInt();
                flag = false;

            }

            catch (Exception e){

                System.out.print("Il valore corrente non è valido, reinserire:");
                flag = true;
                Input.nextLine();

            }
        }

        else{

            try{

                value = database.InputAI(SeqMoves);
                flag = false;

            }

            catch (Exception e){

                System.out.print("Il valore corrente non è valido, reinserire:");
                flag = true;
                Input.nextLine();

            }

        }

        if (value > 0 && value < 10 && ArrMoves[value - 1] == 0 && flag != true){
            this.InsertoSeq(playerID);
        }

        else{

            if (flag == false){

                if (playerID == 1)
                    System.out.print("Questo spazio è occupato, reinserire: ");

                if (playerID == 2) {

                    for (int i = 0; i < 9; i++) {

                        if (ArrMoves[i] == 0) {
                            value = i + 1;
                            this.InsertoSeq(playerID);
                            break;
                        }

                    }
                }
            }

            if (playerID == 1){
                this.InsertMove(playerID);
            }
                

        }

    }

    public boolean MainControl(){
        if (MovesCounter < 9){
            if (ArrMoves[0] == 1 && ArrMoves[1] == 1 && ArrMoves[2] == 1 || 
                ArrMoves[3] == 1 && ArrMoves[4] == 1 && ArrMoves[5] == 1 || 
                ArrMoves[6] == 1 && ArrMoves[7] == 1 && ArrMoves[8] == 1 || 
                ArrMoves[0] == 1 && ArrMoves[3] == 1 && ArrMoves[6] == 1 || 
                ArrMoves[1] == 1 && ArrMoves[4] == 1 && ArrMoves[7] == 1 || 
                ArrMoves[2] == 1 && ArrMoves[5] == 1 && ArrMoves[8] == 1 || 
                ArrMoves[0] == 1 && ArrMoves[4] == 1 && ArrMoves[8] == 1 || 
                ArrMoves[6] == 1 && ArrMoves[4] == 1 && ArrMoves[2] == 1) {
                
                    control = false;
                    System.out.println("Vittoria player 1");
                    result = "L";
            } 
            else{
                if (ArrMoves[0] == 2 && ArrMoves[1] == 2 && ArrMoves[2] == 2 ||
                    ArrMoves[3] == 2 && ArrMoves[4] == 2 && ArrMoves[5] == 2 || 
                    ArrMoves[6] == 2 && ArrMoves[7] == 2 && ArrMoves[8] == 2 || 
                    ArrMoves[0] == 2 && ArrMoves[3] == 2 && ArrMoves[6] == 2 || 
                    ArrMoves[1] == 2 && ArrMoves[4] == 2 && ArrMoves[7] == 2 || 
                    ArrMoves[2] == 2 && ArrMoves[5] == 2 && ArrMoves[8] == 2 || 
                    ArrMoves[0] == 2 && ArrMoves[4] == 2 && ArrMoves[8] == 2 || 
                    ArrMoves[6] == 2 && ArrMoves[4] == 2 && ArrMoves[2] == 2){

                        control = false;
                        System.out.println("Vittoria player 2");
                        result = "W";
                    }
                }
        } 
        else{
            control = false;
            System.out.print("Pareggio");
            result = "D";
        }
        return control;
    }

    public void WatchBoard(){
        for (int i = 0; i < 9; i++){
            
            if (ArrMoves[i] == 1)
                System.out.print("X");
            else{
                if (ArrMoves[i] == 2)
                    System.out.print("0");
                else
                    System.out.print(" ");
            }
            if (i == 2 || i == 5 || i == 8)
                System.out.print(" ");
            else
                System.out.print("|");
            if (i == 2 || i == 5)
                System.out.println("\n- - -");

        }
        System.out.println("");
    }

    public String GetMoves() {
        return SeqMoves;
    }

    public String GetResult() {
        return result;
    }

    public void InsertoSeq(int playerID) {

        ArrMoves[value - 1] = playerID;
        SeqMoves = SeqMoves + Integer.toString(value);
        System.out.println(SeqMoves);
        this.WatchBoard();
        MovesCounter++;

    }

    public void InputClose() {

        Input.close();

    }

}