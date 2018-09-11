#include<iostream>
#include<cstdlib>	//���������ͷ�ļ�
#include<Windows.h>	//�߳�ͷ�ļ�
#include<ctime>		//ʱ��ͷ�ļ�
#include<fstream>
using namespace std;

int n,a[10000000];

void quicksort(int left,int right)
{
	int i,j,t,base;
	i = left;
	j = right;
	base = a[(i+j)/2];	//��׼��
	while(i <= j){
		//�ٴ�������Ҳ�ѯ���õ����ڻ�׼��������
		while(a[i] < base)i++;
		//�ȴ��ұ������ѯ���õ�С�ڻ�׼��������
		while(a[j] > base)j--;
		//�������������������е�λ��
		if (i <= j){
			t=a[i];
			a[i]=a[j];
			a[j]=t;
			i++;
			j--;
		}
	}
	//���õݹ��������
	if (left < j)quicksort(left,j);		//�Ի�׼����߼�������
	if (i < right)quicksort(i,right);	//�Ի�׼���ұ߼�������
}

int main()
{
	ofstream outfile;
	outfile.open("int.txt");
	//�����쳣
	if(!outfile){
		cout << "int.txt������" << endl;
	}

	cin >> n ;	//������Ҫ���ɵ������

	outfile << "���¹��� " << n << " �����ݽ�������" << endl;

	//�����������
	for (int i = 1; i <= n; i++){
		a[i] = rand() % 10000000;
	}

	//�������ǰ������
	outfile << "\n����ǰ������\n" << endl;
	for(int i = 1; i <= n; i++){
		cout << a[i] << " ";
		outfile << a[i] << " ";
	}
	cout << endl;

	//����ʼʱ��
	clock_t startime = clock();

	//���õݹ�������
	quicksort(1,n);

	//�߳�����
	/*Sleep(1000);*/

	//�������ʱ��
	clock_t endtime = clock();

	//�������������
	outfile << "\n����������\n" << endl;
	for(int i = 1; i <= n; i++){
		cout << a[i] << " ";
		outfile << a[i] << " ";
	}
	cout << endl;

	//����̨���ʱ��
	printf("\n������ʱ��-->>%fs\n",(double)(endtime - startime) / CLOCKS_PER_SEC);

	//�ı����ʱ��
	outfile << "\n������ʱ��-->>" << (double)(endtime - startime) / CLOCKS_PER_SEC << " s";

	//�ر��ļ���
	outfile.close();

	return 0;
}