package ֽ��;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
public class ֽ�� {
	char[][] number = new char[2][5];//��ֵ����ֲ���
    char[][] color = new char[2][5];//��ֵĻ�ɫ����
    char[][] threesamecard =new char[2][1];//����������ͬ

    public void getSize(String card, String card2) {//divide String
        String temp[][] = new String[2][5];
        temp[0] = card.split(" ");
        temp[1] = card2.split(" ");
        for (int j = 0; j < 2; j++) {
            for (int i = 0; i < 5; i++) {
                if (temp[j][i].charAt(0) == 'T') number[j][i] = ':';
                else if (temp[j][i].charAt(0) == 'J') number[j][i] = ';';
                else if (temp[j][i].charAt(0) == 'Q') number[j][i] = '<';
                else if (temp[j][i].charAt(0) == 'K') number[j][i] = '=';
                else if (temp[j][i].charAt(0) == 'A') number[j][i] = '>';
                else number[j][i] = temp[j][i].charAt(0);
                color[j][i] = temp[j][i].charAt(1);
            }
            Arrays.sort(number[0]);
            Arrays.sort(number[1]);
            Arrays.sort(color[0]);
            Arrays.sort(color[1]);
        }
    }
    public int typecard(char num[],char col[],int index){//�жϿ��Ƶ�����
        int sum = 0;
        Map<Integer,Integer> map_one=new HashMap<Integer, Integer>();
        Map<Integer,Integer> map_two=new HashMap<Integer, Integer>();//���ӵĴ��漫�����

        if(num[4]-num[1]==4&&col[4]==col[1])return 7;
        else if(col[4]==col[1])return 6;
        else if(num[4]-num[1]==4)return 5;
        else {
            for(int i=0;i<5;i++){
                for(int j=0;j<5;j++){
                    if (num[i]==num[j]){
                        sum++;
                        threesamecard[index][0]=num[i];
                    }
                }
                if(sum==3) return 4;
                sum=0;
            }
            for(int i=0;i<5;i++){//���ӵĴ洢
                if(index==0){
                    if(map_one.get((int)num[i])!=null)
                        map_one.put((int)num[i],1);
                    else
                        map_one.put((int)num[i],2);
                }
                if(index==1){
                    if(map_two.get((int)num[i])!=null)
                        map_two.put((int)num[i],1);
                    else
                        map_two.put((int)num[i],2);
                }
            }
            if(map_one.size()==4)return 3;
            if(map_one.size()==3)return 2;
            if(map_two.size()==4)return 3;
            if (map_two.size()==3)return 2;
            return 1;
        }
    }

    public String getValueByString (String card_one, String card_two){
        getSize(card_one,card_two);
        int score_black=typecard(number[0],color[0],0);
        int score_white=typecard(number[1],color[1],1);
        if(score_black>score_white)return "Black Win";
        else if ((score_black<score_white))return "White Win";
        else {
            switch (score_black){
                case 7:
                case 5:
                    if(number[0][4]==number[1][4])return "Tie";
                    else if(number[0][4]>number[1][4])return "Black Win";
                    else return "White Win";
			case 6:
                    int point=4;
                    while (true){
                        if (number[0][point]>number[1][point])return "White Win";
                        else if(number[0][point]>number[1][point])return "Black Win";
                        else {
                            point--;
                            if (point == -1) return "Tie";
                        }
                    }
			case 4:
                    if(threesamecard[0][0]>threesamecard[0][1])return "Black Win";
                    if(threesamecard[0][0]<threesamecard[0][1])return  "White Win";
                    else return "Tie";

                case 3:
                    break;
                case 2:
                    break;
                case 1:
                    for (int i=4;i>=0;i--){
                        if(number[0][i]>number[1][i])return "black win";
                        else if (number[0][i]<number[1][i]) return "white win";
                        if(i==0) return "Tie";
                    }
                    break;
                default:return "error";
            }
        }
        return "";
    }
}

