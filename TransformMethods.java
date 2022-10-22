/**
 * 
 * @author
 *
 */
public class TransformMethods {
    static final int PICE_SIZE = 3;
    static final int DISSAPEAR_LENGTH = 3; // 3 or more consecutive symbols disappear 
    static final int BOARD_HEIGHT = 20;
    static final int BOARD_WIDTH = 12;
    static final int PIECE_SIZE = 3;

    static final char EMPTY = '-';

    /**
     * Coluna de jogo resultante de colocar uma dada peca numa dada coluna
     * 
     * @param col   A coluna de jogo em questao
     * @param piece A peca em questao
     * @requires col != null && piece != null
     * @ensures col e piece nao sao alteradas
     */
    public static char[] applyTransforms(char[] col, char[] piece) {

        char[] result = copyColumn(col);
        placePiece(result, piece);

        boolean eliminated;

        do {
            eliminated = eliminate(result);
            accomodate(result);
        } while (eliminated);

        return result;
    }

    /**
     * Return a copy of the given column
     * 
     * @param col A column from the game.
	 
	 * * @requires col != null && col.length == BOARD_HEIGHT
     * 
     * @return A copy of the column.
     */
    static char[] copyColumn(char[] col) {
        char[] result = new char[col.length];
        for (int i = 0; i < col.length; i++) {
            result[i] = col[i];
        }
        return result;
    }

    /**
     * Modifies the given column (first parameter) placing the given piece (second
     * parameter) in it if possible.
     * 
     * @param col   A column from the game. //Column size:20
     * @param piece A piece to be placed in the column. (a piece is a vector of 3)
     * 
     * @requires col != null && piece != null
     * 
     * @return The column, modified if possible.
     */
    static void placePiece(char[] col, char[] piece) {
        //Loop until find a empty spot with at lest PIECE_LENGHT spaces before a piece or the end of the column
        for (int pos = 0; pos < col.length; pos++) {
            if (col[pos] != EMPTY || pos == col.length-1) { // Found a piece or the end of the column
                if (pos >= piece.length) { // if there is enough space to place the piece
                    for (int i = 0; i < piece.length; i++) {    
                        // Put the piece starting from
                        col[pos  - i] = piece[piece.length - 1 - i];
                    }
                    return;
                } else {
                    //System.out.println("Não há espaço na coluna");
                    // Piece doesn't fit ---> Lose the game :(
                    return;
                }
            }
        }
    }

    /**
	 * Eliminates the parts of the column that have DISSAPEAR_LENGHT or more consecutive pieces of the same text
	 * 
	 * @param col A column from the game.
	 * 
	 * @requires col != null
	 * 
	 * @return true if at least one line was eliminated, false otherwise.
	 */
    static boolean eliminate(char[] col) {
        int count = 0;
        char lastChar = EMPTY;

        for (int currentPost = 0; currentPost < col.length; currentPost++) {
            if (col[currentPost] == EMPTY) continue;
            if (col[currentPost] == lastChar) count++;
            else { // Found a different char so delete the previous ones if necessary
                if (count >= DISSAPEAR_LENGTH) {
                    for (int idx = 0; idx < count; idx++) {
                        col[(currentPost-1) - idx] = EMPTY;
                    }
                    return true;
                }
                count = 1;
                lastChar = col[currentPost];
            }
            //If end of column and count>=DISSAPEAR_LENGTH
            if (currentPost == col.length - 1 && count >= DISSAPEAR_LENGTH) {
                for (int i = 0; i < count; i++) {
                    col[currentPost - i] = EMPTY;
                }
                return true;
            }
        }
        return false;
    }

    /**
	 * Accomodates the pieces in the column, so that there are no empty spaces between
	 * them.
	 * 
	 * @param col A column from the game.
	 * 
	 * @requires col != null
	 * 
	 * @return The column, modified if possible.
	 */
    static void accomodate(char[] col) {
       
		for(int idx=0;idx<col.length;idx++){
			if(col[idx]!=EMPTY) continue;
			//Found a piece
			for(int idxAux=idx+1;idxAux<col.length;idxAux++){
				if(col[idxAux]==EMPTY) {
					//Move entire column down // --$-$ -> ---$$ 
					for(int idxAux2=idxAux;idxAux2>idx;idxAux2--){ //O(N) can be imroved by counting the number of empty spaces
						col[idxAux2]=col[idxAux2-1]; // Copy the piece before the empty space  
					}
					col[idx]=EMPTY;
					break;
				}
			}
		}
	}

}
