public class Num1 {

	public static void main(String[] args) {
		int A[][] = new int [][] {{0,0,0,9}, {0,1,0,0},
			{0,0,0,0}, {0,0,7,0}, {0,0,0,0},
			{3,0,0,0}, {0,0,0,0}};
			trans(A);

	}
			
//전치 행렬의 희소행렬에 대한 2차원 배열
public static void trans(int A[][]) {
	int num_zero = 0;
	for (int i=0; i<A.length; i++) {
		for (int j=0; j<A[0].length; j++) {
			if (A[i][j]==0)
				num_zero++;
		} // 0인 원소의 개수 구하기
	}
	int number = (A.length)*(A[0].length)-num_zero; 
			int a[][] = new int[number+1][3];
			int b[][] = new int[number+1][3]; 
			int i=0, j=0, k=0;
			while (i<A.length) {
				for (j=0; j<A[0].length; j++)  {
					if (A[i][j]!=0) {
						a[0][0] = A.length;
						a[0][1] = A[0].length;
						a[0][2] = number;
						a[k+1][0] = i;
						a[k+1][1] = j;
						a[k+1][2] = A[i][j];
							k++;
					}
				} 
			i++;
		} // 행렬 A의 희소 행렬에 대한 2차원 배열 a
			
		int m, n, v, p;
		m = a[0][0];
		n = a[0][1];
		v = a[0][2];
		b[0][0] = n;
		b[0][1] = m;
		b[0][2] = v;
		
		if (v>0) {
			p=1;
			for (int x=0; x<=n; x++) {
				for (int y=1; y<=v; y++) {
					if (a[y][1]==x) {
						b[p][0]=a[y][1];
						b[p][1]=a[y][0];
						b[p][2]=a[y][2];
						p++;
					}
				}
			}
System.out.println("[행렬 A의 희소행렬에 대한 2차원 배열 a]");
			for (int f=0; f<number+1; f++) {
				for (int g=0; g<3; g++) {
				System.out.printf("%3d", a[f][g]);
				}
				System.out.println();
			} 
// 행렬 aa의 희소행렬에 대한 2차원 배열 a 보이기	
		}
		System.out.println("[전치 행렬의 희소행렬에 대한 2차원 배열 b]");
		for (int c=0; c<5; c++) {
			for (int d=0; d<3; d++) {
				System.out.printf("%3d", b[c][d]);
			}
			System.out.println();
		}
	}
}
