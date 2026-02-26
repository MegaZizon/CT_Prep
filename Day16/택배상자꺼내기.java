package Day16;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class 택배상자꺼내기 {

    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    public static void main(String[] args) throws Exception{

        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int NUM = Integer.parseInt(st.nextToken());

        택배상자꺼내기 question = new 택배상자꺼내기();

        System.out.println(question.solution(N,W,NUM));

    }

    int[][] arr;

    int solution(int n, int w, int num){

        int height = ( n / w ) + 1;
        if(n % w == 0 )
            height--;
        int count = 1;
        int solH=0;
        int solW=0;

        arr = new int[height][w];

        for(int i=0; i<height; i++) {
            for(int j=0; j<w; j++) {

                if(count > n) break;

                if(i % 2 == 0){
                    arr[i][j] = count;
                    if(count==num){
                        solH = i;
                        solW = j;
                    }
                }else{
                    arr[i][w-1-j] = count;
                    if(count==num){
                        solH = i;
                        solW = w-1-j;
                    }
                }
                count++;
            }
        }

        if(arr[height-1][solW] != 0){
            return height-solH;
        }else{
            return height-solH-1;
        }

    }
}
