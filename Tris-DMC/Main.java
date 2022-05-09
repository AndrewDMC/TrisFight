
public class Main{
    public static void main(String[] args){

        Tris tris=new Tris();
        Database database = new Database();

        tris.WatchBoard();
        
        do{
            tris.InsertMove(1);

            if(!tris.MainControl()) break;
            
            tris.WatchBoard();
            tris.InsertMove(2);
            
            
            if(!tris.MainControl()) break;

            tris.WatchBoard();

        }while(tris.MainControl());
        
       

        if(!tris.MainControl()){

            tris.InputClose();
            database.InsertToDB(tris.GetMoves(), tris.GetResult());
            database.WatchDB();
        
        }
    }
}