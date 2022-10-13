package lab_2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.lang.Math;

public class Main {
	
	static List<List<Integer>> perms = new ArrayList<>();
	
	public static Boolean isNumeric(String s) {
		
		return s.matches("\\d+"); 
		
	}
	
	public static void main(String[] args) {
		
		int c, x = 0;
		
		int w, h, i, j;
		
		String e = "";

		List<Float> l = new ArrayList<Float>();
		
		Matrix m1 = new Matrix(0, 0);
		
		System.out.println("Choose option of matrix 1 definition:\n1. manual\n2. row vector");
		
		Scanner sc = new Scanner(System.in);
		
		do {
			
			e = sc.nextLine();
			
			c = Integer.parseInt(e);
			
		}
		
		while (!isNumeric(e) || Integer.parseInt(e) != 1 && Integer.parseInt(e) != 2);
		
		//System.out.println(e);
		
		if (c == 1) {
			
			System.out.println("Enter height:");
			
			h = Integer.parseInt(sc.nextLine());

			System.out.println("Enter width:");
			
			w = Integer.parseInt(sc.nextLine());
			
			System.out.println("Enter elements:");
			
			for (int n = 0; n < w * h; n++) {
				
				l.add(Float.parseFloat(sc.nextLine()));
				
			}
			
			m1 = new Matrix(h, w, l);
			
		}
		
		if (c == 2) {
			
			System.out.println("Enter width:");
			
			w = Integer.parseInt(sc.nextLine());
			
			m1 = rowVec(w);
			
		}
		
		Matrix m2 = new Matrix(0, 0);
		
		System.out.println("Choose option of matrix 2 definition (optional):\n1. manual\n2. row vector\n3. copy matrix 1\n4. skip");
		
		e = "";
		
		while (!isNumeric(e) || Integer.parseInt(e) < 1 || Integer.parseInt(e) > 4) {
			
			e = sc.nextLine();
			
			c = Integer.parseInt(e);
			
		}
		
		switch (c) {
			
			case 1:
				
				System.out.println("Enter height:");
				
				h = Integer.parseInt(sc.nextLine());
				
				System.out.println("Enter width:");
				
				w = Integer.parseInt(sc.nextLine());
				
				System.out.println("Enter elements:");
				
				for (int n = 0; n < h * w; n++) {
					
					l.add(Float.parseFloat(sc.nextLine()));
					
				}
				
				m2 = new Matrix(h, w, l);
				
				break;
				
			case 2:
				
				System.out.println("Enter width:");
				
				w = Integer.parseInt(sc.nextLine());
				
				m2 = rowVec(w);
				
				break;
				
			case 3:
				
				m2 = new Matrix(m1);
				
				break;
				
		}
		
		while (c != 0) {
		
			System.out.println("Choose operation with the matrix:\n1. get element\n2. get row\n3. get column\n4. get size\n5. m1, m2: check equality\n6. get hash-code"
					+ "\n7. get matrix\n8. inverse matrix\n0. exit");
			
			e = "";
			
			while (!isNumeric(e) || Integer.parseInt(e) < 0 || Integer.parseInt(e) > 10) {
				
				e = sc.nextLine();
				
				c = Integer.parseInt(e);
				
			}
			
			e = "";
			
			switch(c) {
				
				case 1:
					
					System.out.println("Choose matrix (1, 2):");
					
					while (!isNumeric(e) || Integer.parseInt(e) != 1 && Integer.parseInt(e) != 2) {
						
						e = sc.nextLine();
						
						x = Integer.parseInt(e);
						
					}
					
					System.out.println("Enter i: ");
					
					i = Integer.parseInt(sc.nextLine());
					
					System.out.println("Enter j: ");
					
					j = Integer.parseInt(sc.nextLine());
					
					if (x == 1) System.out.println(m1.get(i, j));
					if (x == 2) System.out.println(m2.get(i, j));
					
					break;
					
				case 2:
					
					System.out.println("Choose matrix (1, 2):");
					
					while (!isNumeric(e) || Integer.parseInt(e) != 1 && Integer.parseInt(e) != 2) {
						
						e = sc.nextLine();
						
						x = Integer.parseInt(e);
						
					}
					
					System.out.println("Enter i: ");
					
					i = Integer.parseInt(sc.nextLine());
					
					if (x == 1) m1.getRow(i);
					if (x == 2) m2.getRow(i);
					
					break;

				case 3:
					
					System.out.println("Choose matrix (1, 2):");
					
					while (!isNumeric(e) || Integer.parseInt(e) != 1 && Integer.parseInt(e) != 2) {
						
						e = sc.nextLine();
						
						x = Integer.parseInt(e);
						
					}
					
					System.out.println("Enter j: ");
					
					j = Integer.parseInt(sc.nextLine());
					
					if (x == 1) m1.getCol(j);
					if (x == 2) m2.getCol(j);
					
					break;
					
				case 4:
					
					System.out.println("Choose matrix (1, 2):");
					
					while (!isNumeric(e) || Integer.parseInt(e) != 1 && Integer.parseInt(e) != 2) {
						
						e = sc.nextLine();
						
						x = Integer.parseInt(e);
						
					}
					
					if (x == 1) System.out.println(String.format("%dx%d", m1.width(), m1.height()));
					if (x == 2) System.out.println(String.format("%dx%d", m2.width(), m2.height()));
					
					break;
					
				case 5:
					
					System.out.println(m1.equals(m2) ? "True" : "False");
			
					break;
					
				case 6:
					
					System.out.println("Choose matrix (1, 2): ");
					
					while (!isNumeric(e) || Integer.parseInt(e) != 1 && Integer.parseInt(e) != 2) {
						
						e = sc.nextLine();
						
						x = Integer.parseInt(e);
						
					}
					
					if (x == 1) System.out.println(String.valueOf(m1.hashCode()));
					if (x == 2) System.out.println(String.valueOf(m2.hashCode()));
					
					break;
					
				case 7:
					
					System.out.println("Choose matrix (1, 2):");
					
					while (!isNumeric(e) || Integer.parseInt(e) != 1 && Integer.parseInt(e) != 2) {
						
						e = sc.nextLine();
						
						x = Integer.parseInt(e);
						
					}
					
					if (x == 1) m1.get();
					if (x == 2) m2.get();
					
					break;
					
				case 8:
					
					System.out.println("Choose matrix (1, 2):");
					
					while (!isNumeric(e) || Integer.parseInt(e) != 1 && Integer.parseInt(e) != 2) {
						
						e = sc.nextLine();
						
						x = Integer.parseInt(e);
						
					}
					
					if (x == 1 && m1.width() == m1.height()) {
						
						int det = det(m1);
						
						m1 = inverse(m1, det);
						
						m1.get();
					
					}
					if (x == 2 && m2.width() == m2.height()) {
						
						int det = det(m2);
						
						m2 = inverse(m2, det);
						
						m2.get();
					
					}
			}
		}
	}
	
	public static Matrix rowVec(int w) {
		
		List<Float> l = new ArrayList<Float>();
		
		for(int i = 0; i < w; i++) {
				
			l.add((float) Math.round(Math.random() * 100));
			
		}
		
		Matrix m = new Matrix(1, w, l);
		
		return m;
		
	}
	
	public static Matrix trans(Matrix m) {
		
		if (m.width() != m.height()) throw new ArithmeticException("matrix must be square");
		
		Matrix m2 = new Matrix(m.height(), m.width());
		
		float[][] m21 = new float[m.height()][m.width()];
		
		m21 = m.getCopy();
		
		for (int y = 0; y < m.height(); y++) {
			for (int x = 0; x < m.height(); x++) {
				
				m21[y][x] = m.getCopy()[x][y];
				
			}
		}
		
		m2.set(m2.height(), m2.width(), m21);
		
		return m2;
		
	}
	
	public static void perms(int n) {
		
		List<Integer> raw = new ArrayList<>();
		
		perms = new ArrayList<>();
		
		for (int i = 0; i < n; i++) {
			
			raw.add(i);
			
		}
		
		for (int i = 0; i < n; i++) {
			
			List<Integer> rest = new ArrayList<>(raw);
			
			List<Integer> perm = new ArrayList<>();
			
			perm.add(rest.get(i));
			
			rest.remove(i);
			
			perms2(perm, rest);
			
		}
	}
	
	public static void perms2(List<Integer> perm, List<Integer> rest) {
		
		for (int i = 0; i < rest.size(); i++) {
			
			List<Integer> rest2 = new ArrayList<>(rest);
			
			List<Integer> perm2 = new ArrayList<>(perm);
			
			if (rest2.size() > 1) {
			
				perm2.add(rest2.get(i));
				
				rest2.remove(i);
			
			}
			
			if (rest.size() > 2) perms2(perm2, rest2);
			
			else {
				
				perm2.add(rest2.get(0));
				
				perms.add(perm2);
				
			}
		}
		
		if (rest.size() == 0) perms.add(Arrays.asList(new Integer[]{0}));
		
	}
	
	public static int sign(List<Integer> perm) {
		
		int invs = 0;
		
		for (int y = 0; y < perm.size(); y++) {
			
			for (int x = y + 1; x < perm.size(); x++) {
				
				if(perm.get(y) > perm.get(x)) invs++;
				
			}
		}
		
		if (invs % 2 == 0) return 1;
		
		return -1;
		
	}
	
	public static int det(Matrix m) {
		
		if (m.width() != m.height()) throw new ArithmeticException("matrix must be square");
		
		int sum = 0;
		
		perms(m.width());
	
		for (int i = 0; i < perms.size(); i++) {
			
			int sumd = 1;
			
			for (int n = 0; n < perms.get(0).size(); n++) {
			
				sumd *= m.get(n, perms.get(i).get(n));
				
			}
			
			sumd *= sign(perms.get(i));
			
			sum += sumd;
			
		}
		
		return sum;
		
	}
	
	public static float minor(Matrix m, int y, int x) {

		List<Float> l = new ArrayList<>();
		
		for (int j = 0; j < m.height(); j++) {
			for (int i = 0; i < m.height(); i++) {
				
				if (j != y && i != x) l.add(m.getCopy()[j][i]);
				
			}
		}
		
		Matrix m2 = new Matrix(m.height() - 1, m.width() - 1, l);
		
		return det(m2);
		
	}
	
	public static Matrix inverse(Matrix m, float det) {
		
		if (m.width() != m.height()) throw new ArithmeticException("matrix must be square");
		if (det == 0) throw new ArithmeticException("inverse matrix doesn't exist");
		
		Matrix mTrans2;
		
		List<Float> mins = new ArrayList<>();
		
		for (int y = 0; y < m.height(); y++) {
			for (int x = 0; x < m.height(); x++) {
				
				mins.add((float) Math.pow(-1, x + y) * minor(m, y, x) / det);
				
			}
		}
		
		mTrans2 = new Matrix(m.height(), m.width(), mins);
		
		mTrans2 = trans(mTrans2);
		
		return mTrans2;
		
	}
}

class Matrix {
	
	private int w, h;
	
	private float M[][];
	
	public Matrix(int h, int w) {
		
		if (w < 0) throw new ArithmeticException("width cannot be negative");
		if (h < 0) throw new ArithmeticException("height cannot be negative");
		
		this.w = w;
		this.h = h;
		
		M = new float[h][w];
		
	}
	
	public int width() {
		
		return w;
		
	}
	
	public int height() {
		
		return h;
		
	}
	
	public float get(int y, int x) {
		
		return M[y][x];
		
	}
	
	public void getRow(int y) {
		
		for (int i = 0; i < w; i++) {
			
			System.out.print(String.valueOf(M[y][i]) + " ");
			
		}
		
		System.out.println();
		
	}
	
	public void getCol(int x) {
		
		for (int i = 0; i < h; i++) {
			
			System.out.println(String.valueOf(M[i][x]));
			
		}
	}
	
	public Matrix(int h, int w, List<Float> l) {
		
		if (w < 0) throw new ArithmeticException("width cannot be negative");
		if (h < 0) throw new ArithmeticException("height cannot be negative");
		
		this.h = h;
		this.w = w;
		
		M = new float[h][w];
		
		for (int x = 0; x < w; x++) {
			
			for (int y = 0; y < h; y++) {
				
				M[y][x] = l.get(x + y * w);
				
			}
		}
	}
	
	public Matrix(Matrix m) {
		
		h = m.height();
		w = m.width();
		
		this.set(h, w, m.getCopy());
		
	}
	
	public float[][] getCopy() {
		
		float[][] M2 = new float[h][w];
		
		for (int y = 0; y < h; y++) {
			
			for (int x = 0; x < w; x++) {
				
				M2[y][x] = M[y][x];
			
			}
		}
		
		return M2;
		
	}
	
	public void set(int h, int w, float M[][]) {
		
		if (w < 0) throw new ArithmeticException("width cannot be negative");
		if (h < 0) throw new ArithmeticException("height cannot be negative");
		
		this.h = h;
		
		this.w = w;
	
		for (int y = 0; y < h; y++) {
			
			for (int x = 0; x < w; x++) {
				
				this.M[y][x] = M[y][x];
			
			}
		}
	}
	
	public void get() {
		
		for (int y = 0; y < h; y++) {
			
			for (int x = 0; x < w; x++) {
				
				System.out.print(M[y][x] + " ");
				
			}
			
			System.out.println();
			
		}
	}
	
	public Boolean equals(Matrix m2) {
	
		if (this.w != m2.width()) return false;
		if (this.h != m2.height()) return false;
		
		for (int y = 0; y < h; y++) {
			for (int x = 0; x < w; x++) {
			
				if (M[y][x] != m2.getCopy()[y][x]) return false;
				
			}
		}
		
		return true;
		
	}
	
	public int hashCode(Matrix m2) {
		
		int p = 31;
		
		int r = 1;
		
		for (int y = 0; y < h; y++) {
			for (int x = 0; x < w; x++) {
				
				r = p * r + ((Object) m2.get(y, x)).hashCode();
				
			}
		}
		
		return r;
		
	}
}

final class imMatrix {
	
	private int w, h;
	
	private float M[][];
	
	public imMatrix(int h, int w) {
		
		if (w < 0) throw new ArithmeticException("width cannot be negative");
		if (h < 0) throw new ArithmeticException("height cannot be negative");
		
		this.w = w;
		this.h = h;
		
		M = new float[h][w];
		
	}
	
	public int width() {
		
		return w;
		
	}
	
	public int height() {
		
		return h;
		
	}
	
	public float get(int y, int x) {
		
		final float t = M[y][x];
		
		return t;
		
	}
	
	public void getRow(int y) {
		
		for (int i = 0; i < w; i++) {
			
			System.out.print(String.valueOf(M[y][i]) + " ");
			
		}
		
		System.out.println();
		
	}
	
	public void getCol(int x) {
		
		for (int i = 0; i < h; i++) {
			
			System.out.println(String.valueOf(M[i][x]));
			
		}
	}
	
	public imMatrix(int h, int w, List<Float> l) {
		
		if (w < 0) throw new ArithmeticException("width cannot be negative");
		if (h < 0) throw new ArithmeticException("height cannot be negative");
		
		this.h = h;
		this.w = w;
		
		M = new float[h][w];
		
		for (int x = 0; x < w; x++) {
			
			for (int y = 0; y < h; y++) {
				
				M[y][x] = l.get(x + y * w);
				
			}
		}
	}
	
	public imMatrix(imMatrix m) {
		
		h = m.height();
		w = m.width();
		
		this.set(h, w, m.getCopy());
		
	}
	
	public float[][] getCopy() {
		
		float[][] M2 = new float[h][w];
		
		for (int y = 0; y < h; y++) {
			
			for (int x = 0; x < w; x++) {
				
				M2[y] = Arrays.copyOf(M[y], M[y].length);
			
			}
		}
		
		return M2;
		
	}
	
	private void set(int h, int w, float M[][]) {
		
		if (w < 0) throw new ArithmeticException("width cannot be negative");
		if (h < 0) throw new ArithmeticException("height cannot be negative");
		
		this.h = h;
		
		this.w = w;
	
		for (int y = 0; y < h; y++) {
			
			for (int x = 0; x < w; x++) {
				
				this.M[y][x] = M[y][x];
			
			}
		}
	}
	
	public void get() {
		
		for (int y = 0; y < h; y++) {
			
			for (int x = 0; x < w; x++) {
				
				System.out.print(M[y][x] + " ");
				
			}
			
			System.out.println();
			
		}
	}
	
	public Boolean equals(imMatrix m2) {
	
		if (this.w != m2.width()) return false;
		if (this.h != m2.height()) return false;
		
		for (int y = 0; y < h; y++) {
			for (int x = 0; x < w; x++) {
			
				if (M[y][x] != m2.getCopy()[y][x]) return false;
				
			}
		}
		
		return true;
		
	}
	
	public int hashCode(imMatrix m2) {
		
		int p = 31;
		
		int r = 1;
		
		for (int y = 0; y < h; y++) {
			for (int x = 0; x < w; x++) {
				
				r = p * r + ((Object) m2.get(y, x)).hashCode();
				
			}
		}
		
		return r;
		
	}
}