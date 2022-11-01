class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        HashMap<Integer, Integer>[] rows = new HashMap[9];
        HashMap<Integer, Integer>[] cols = new HashMap[9];
        HashMap<Integer, Integer>[] boxes =  new HashMap[9];
        
        
        for(int i=0; i<9; i++){
            // [{k:v, k1:v1,.....}, {},{},{}.......,{}]
            rows[i] = new HashMap<Integer, Integer>();
            cols[i] = new HashMap<Integer, Integer>();
            boxes[i] = new HashMap<Integer, Integer>();
            
        }
        
        
        for(int i=0; i<9; i++){
            for(int j=0; j<9;j++){
                
                if(board[i][j] != '.'){
                    
                    int element = (int)board[i][j];
                    int boxIndex = (i/3)*3 + (j/3);
                    
                    rows[i].put(element, rows[i].getOrDefault(element,0) + 1);
                    cols[j].put(element, cols[j].getOrDefault(element, 0)+1);
                    boxes[boxIndex].put(element, boxes[boxIndex].getOrDefault(element,0)+1);
                    
                    if(rows[i].get(element) > 1 || cols[j].get(element) > 1 || boxes[boxIndex].get(element) > 1){
                        return false;
                    }
                    
                }             
                
                
            }
            
            
        }
        
        return true;
        
        
    }
}