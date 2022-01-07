import java.util.Random;
import java.util.Scanner;

public class Mayin {
    int rowNumber, colNumber,size;
    int[][] map;
    int[][] board;
    boolean game=true;

    Random rand=new Random();
    Scanner scan=new Scanner(System.in);

    public Mayin(int _rowNumber, int _colNumber)
    {
        this.rowNumber=_rowNumber;
        this.colNumber=_colNumber;
        this.map=new int[rowNumber][colNumber];
        this.board=new int[rowNumber][colNumber];
        this.size=_rowNumber*_colNumber;
    }

    public void run(){
        prepareGame();
        print(map);
        while(game){
            System.out.println("Oyun başladı!!");
            System.out.println("Mayına basmamak için satır değeri giriniz.");
            int rowUser=scan.nextInt();
            System.out.println("Mayına basmamak için sütün değeri giriniz.");
            int colUser=scan.nextInt();
            //mayına bastık mı basmadık mı kontrol ediyoruz.
            if(map[rowUser][colUser]!=-1){//mayına basmadık
                check(rowUser,colUser);//mayına basmadık bu nedenle bastığımız yerin etrafında mayın var mı yok mu ona bakacağız.
                print(board);
            }
            else{//mayına bastık.
                game=false;
                System.out.println("Oyun bitti!");
            }
        }
    }

    public void check(int r, int c){//mayına basmadığımız zamanlarda, bastığımız hücrenin etrafında mayın var mı yok mu kontrol ediyoruz.
        if(map[r][c]==0)
        {
            if((c<colNumber-1) && (map[r][c+1]==-1)){
                board[r][c]++;
            }
            if(c>0 && map[r][c-1]==-1){
                board[r][c]++;
            }
            if(r<rowNumber-1 && map[r+1][c]==-1){
                board[r][c]++;
            }
            if(r>0 && map[r-1][c]==-1){
                board[r][c]++;
            }
            if(board[r][c]==0)//eğer hücrenin etrafında yoksa mayın onun değerini -2 ye eşitle.
                board[r][c]=-2;
        }

        }

    public void prepareGame(){
        int randRow, randCol,count=0;
        while(count!=size/4){//mayın sayısını belirledik.
            randRow=rand.nextInt(rowNumber);//0 ile rowNumber arasında rastgele bir sayı atar
            randCol=rand.nextInt(colNumber);
            if(map[randRow][randCol]!=-1){//mayınları yerleştiriyoruz
                map[randRow][randCol]=-1;
                count++;
            }
        }
    }

    public void print(int[][] arr){//haritaları ekrana göstereceğiz.
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++)
            {
                if(arr[i][j]<0)//tablonun ekranda düzenli gözükmesi için oluşturduk.
                    System.out.print(arr[i][j]);//ancak -1 ise boşluk olmasın zaten (-) işareti o boşluğu dolduracak.
                else
                    System.out.print(" "+arr[i][j]);//0 sa boşluk olsun arada
            }
            System.out.println();
        }
    }
}
