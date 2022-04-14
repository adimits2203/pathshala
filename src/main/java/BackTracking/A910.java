package BackTracking;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class A910 {

    public static void main(String[] args) {
        int[][] maze = {{0,0,0,0},{0,-1,0,0},{0,0,0,0},{0,0,0,0}};
        possiblePaths(maze, 0, 0, new ArrayList());

    }

    /**
     * Simple maze problem
     * rat is placed on the start if the maze and he has to travel to end of the maze
     * 0 - good to travel
     * 1- poisonous
     *
     * samples ip -
     *
     * [0] 0  0
     * 0 -1   0
     * 0  0  {0}
     *
     * [] --> source
     * {} --> destination
     *
     * only two movements are allowed --> RIGHT and DOWN
     *
     * o/p: possible paths
     *
     * 0,0 --> 0,1 --> 0,2 --> 1,2 --> 2,2
     *
     * Idea:
     *
     * Do something
     * recurse
     * Undo the 'something'
     * */
     private static void possiblePaths(int[][] maze, int i, int j, List paths){
         if(i==j && j == maze[0].length-1){
             paths.stream().forEach(System.out::print);
             System.out.print(i+"+"+j);
             System.out.println("");
         }
         //paths.add(new Pair<>(i, j));
         if(isValidLoc(maze,i,j+1)){
             possiblePaths(maze,i,j+1,paths);
         }
         if(isValidLoc(maze,i+1,j)){
             possiblePaths(maze,i+1,j,paths);
         }
        // paths.remove(new Pair<>(i, j));
     }

    private static boolean isValidLoc(int[][] maze, int i, int j) {
        if(i >= maze.length || j >= maze[0].length){
            return false;
        }
         if(maze[i][j]==-1){
             return false;
         }

         return true;
    }


}
