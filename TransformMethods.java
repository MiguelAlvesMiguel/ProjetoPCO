/**
 * 
 * @author 
 *
 */
public class TransformMethods {
	static final int SIZE_OF_PIECE = 3;
	static final char EMPTY = '-';

	/**
	 * Coluna de jogo resultante de colocar uma dada peca numa dada coluna 
	 * @param col A coluna de jogo em questao 
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
		} while(eliminated);
		
		return result;
	}

	// FALTA DOCUMENTACAO JAVADOC AQUI
	static char[] copyColumn(char[] col) {
		// TO DO	
		return null;
	}

	// FALTA DOCUMENTACAO JAVADOC AQUI
	static void placePiece(char[] col, char[] piece) {
		// TO DO	
	}

	// FALTA DOCUMENTACAO JAVADOC AQUI
	static boolean eliminate(char[] col) {
		// TO DO	
		return false;
	}

	// FALTA DOCUMENTACAO JAVADOC AQUI
	static void accomodate(char[] col) {
		// TO DO	
	}
	
}
