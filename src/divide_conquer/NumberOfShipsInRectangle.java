package divide_conquer;

public class NumberOfShipsInRectangle {
    public static void main(String[] args) {
        NumberOfShipsInRectangle obj=new NumberOfShipsInRectangle();
        int res=obj.countShips(new Sea(), new int[]{4,4}, new int[]{0,0});
        System.out.println(res);
    }
    public int countShips(Sea sea, int[] topRight, int[] bottomLeft) {

        if(!sea.hasShips(topRight, bottomLeft)) return 0;
        if(topRight[0]<bottomLeft[0] || topRight[1]<bottomLeft[1]) return 0;
        if(topRight[0]==bottomLeft[0] && topRight[1]==bottomLeft[1]) return 1;

        int middleRow=(topRight[0]+bottomLeft[0])/2;
        int middleCol=(topRight[1]+bottomLeft[1])/2;

        int[] middle={middleRow, middleCol};
        int[] middleTop={topRight[0], middleCol};
        int[] middleRight={middleRow, topRight[1]};

        int total=0;
        //bottom left
        total+=countShips(sea, middle, bottomLeft);

        //top left
        total+=countShips(sea, middleTop, new int[]{middleRow+1, bottomLeft[1]});

        //bottom right
        total+=countShips(sea, middleRight, new int[]{bottomLeft[0], middleCol+1});

        //top right
        total+=countShips(sea, topRight, new int[]{middleRow+1, middleCol+1});

        return total;
    }
}

class Sea {
    int[][] shipLocations={{1,1},{2,2},{3,3},{5,5}};

    public boolean hasShips(int[] topRight, int[] bottomLeft) {
        for(int[] shipLocation : shipLocations) {
            if(shipLocation[0]>=bottomLeft[0] && shipLocation[1]>=bottomLeft[1]
                    && shipLocation[0]<=topRight[0] && shipLocation[1]<=topRight[1]) {
                return true;
            }
        }
        return false;
    }
}
