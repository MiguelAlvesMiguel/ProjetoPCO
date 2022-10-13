/**
 * Esta classe permite testar a funcao applyTransforms  
 * da classe TransformMethods
 * 
 * @author minunes
 * @date Outubro 2022
 */
public class PCOFase1 {

	/**
	 * Permite testar as funcoes da classe TransformMethods
	 * para varios valores dos seus parametros;   
	 * Imprimem-se os resultados no standard output
	 * @param args Nao utilizado
	 */
	public static void main(String[] args) {
		char[] column1 = {'-','-','-','-','-','-','-','-','!','$','$'};
		char[] column2 = {'$','#','!','!','@','!','$','#','!','$','$'};
		char[] column3 = {'-','-','-','-','-','-','-','-','-','-','-','-'};
		char[] column4 = {'-','-','-','$','!','!'};
		char[] column5 = {'-','-','$','$','!','!'};
		char[] column6 = {'-','@','$','$','!','!'};
		char[] column7 = {'-','-','-','-','-','$','$','!'};
		
		char[] peca1 = {'$','!','!'};
		char[] peca2 = {'$','!','!'};
		char[] peca3 = {'$','!','!'};
		char[] peca4 = {'!','$','$'};
		char[] peca5 = {'%','$','$'};
		
		// Testar metodos copyColumn e placePiece
		System.out.println("=============================");
		System.out.println("TESTES NIVEL 1:");
		testLevel1(column1,peca1);
		testLevel1(column2,peca2);
		testLevel1(column3,peca3);
		
		// Testar tambem metodo eliminate
		System.out.println("=============================");
		System.out.println("TESTES NIVEL 2:");
		testLevel2(column7,peca4);
		testLevel2(column4,peca5);
		testLevel2(column7,peca3);

		// Testar tambem metodo accomodate
		System.out.println("=============================");
		System.out.println("TESTES NIVEL 3:");
		testLevel3(column1, peca1);
		testLevel3(column2, peca2);
		testLevel3(column3, peca3);
		testLevel3(column5, peca4);
		testLevel3(column6, peca4);
		testLevel3(column7, peca4);
	}
	
	/**
	 * Imprimir no standard output a coluna e a peca originais e de seguida 
	 * a coluna resultante de invocar as funcoes copyArea e placePiece da  
	 * classe TransformMethods 
	 * @param col A coluna original
	 * @param piece A peca a colocar
	 * @requires col != null && piece != null 
	 */
	private static void testLevel1(char[] col, char[] piece) {
		System.out.println("=============================");
		System.out.println("COLUNA ORIGINAL:");
		printColumn(col);
		System.out.print("PEÇA A COLOCAR:");
		printColumn(piece);
		System.out.println("COLUNA COPIA:");
		char[] result = TransformMethods.copyColumn(col);
		printColumn(result);
		System.out.println("COLUNA JA' COM PECA COLOCADA:");
		TransformMethods.placePiece(result, piece);
		printColumn(result);
		System.out.println();
	}
	
	/**
	 * Imprimir no standard output a coluna e a peca originais e de seguida 
	 * a coluna resultante de invocar as funcoes copyArea, placePiece e   
	 * eliminate da classe MetodosTransformacao 
	 * @param col A coluna original
	 * @param piece A peca a colocar
	 * @requires col != null && piece != null 
	 */
	private static void testLevel2(char[] col, char[] piece) {
		System.out.println("=============================");
		System.out.println("COLUNA ORIGINAL:");
		printColumn(col);
		System.out.print("PEÇA A COLOCAR:");
		printColumn(piece);
		char[] result = TransformMethods.copyColumn(col);
		TransformMethods.placePiece(result, piece);
		System.out.println("COLUNA DEPOIS DE ELIMINACAO:");
		boolean elimin = TransformMethods.eliminate(result);
		System.out.println("Eliminou? " + elimin);
		printColumn(result);
		System.out.println();
	}
	
	/**
	 * Imprimir no standard output a coluna e a peca originais e de seguida 
	 * a coluna resultante de invocar a funcao aplicaTransformacoes da  
	 * classe MetodosTransformacao 
	 * @param col A coluna original
	 * @param piece A peca a colocar
	 * @requires col != null && piece != null 
	 */
	private static void testLevel3(char[] col, char[] piece) {
		System.out.println("=============================");
		System.out.println("COLUNA ORIGINAL:");
		printColumn(col);
		System.out.print("PEÇA A COLOCAR:");
		printColumn(piece);
		System.out.println("COLUNA FINAL:");
		printColumn(TransformMethods.applyTransforms(col, piece));
		System.out.println();
	}
	
	/**
	 * Imprimir os elementos de um vetor de carateres no standard output
	 * @param v O vetor a imprimir
	 * @requires v != null 
	 */
	private static void printColumn(char[] v) {
		for(int i = 0 ; i < v.length ; i++) {
				System.out.print(v[i]);
		}		
		System.out.println();
	}

}
