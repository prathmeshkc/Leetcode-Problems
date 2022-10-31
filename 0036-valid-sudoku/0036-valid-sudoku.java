class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        HashSet<String> set = new HashSet<>();
        
        for(int row=0; row<9; row++){
            for(int col=0; col<9;col++){
                
                if(board[row][col] != '.'){
                    int boxIndex = (row/3)*3 + (col/3);
                    String rowStr = "row" + row + board[row][col];
                    String colStr = "col" + col + board[row][col];
                    String boxStr = "box" + boxIndex + board[row][col];
                    
                    if(!set.add(rowStr)){
                        return false;
                    }
                    
                    if(!set.add(colStr)){
                        return false;
                    }
                    
                    if(!set.add(boxStr)){
                        return false;
                    }               
                    
                }
                
                
                
            }
        }
        
        
        
        
        
        
        return true;
    }
}