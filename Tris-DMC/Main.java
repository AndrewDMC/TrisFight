
public class Main
{
    public static void main(String[] args) {

        Tris tris=new Tris();
        int player1=0;
        int player2=0;
        String mosse = "";
        String esito = "";
        Database database = new Database();

        

        
        boolean MainChecker=true;
        tris.output();
        do{
            tris.input(1);
            MainChecker = tris.controllo();

            if(!MainChecker) break;
            
            mosse = tris.GetMosse();
            tris.output();
            tris.input(2);
            MainChecker = tris.controllo();
            
            if(!MainChecker) break;

            tris.output();

        }while(MainChecker);
        
       

        if(!MainChecker){

            esito = tris.GetEsito();
            mosse = tris.GetMosse();
            database.InsertToDB(mosse, esito);
            database.WatchDB();
        
    }
             
        

}

}