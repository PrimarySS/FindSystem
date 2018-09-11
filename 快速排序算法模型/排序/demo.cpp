#include<iostream>
#include<cstdlib>	//生成随机数头文件
#include<Windows.h>	//线程头文件
#include<ctime>		//时间头文件
#include<fstream>
using namespace std;

int n,a[10000000];

void quicksort(int left,int right)
{
	int i,j,t,base;
	i = left;
	j = right;
	base = a[(i+j)/2];	//基准数
	while(i <= j){
		//再从左边往右查询，得到大于基准数的整数
		while(a[i] < base)i++;
		//先从右边往左查询，得到小于基准数的整数
		while(a[j] > base)j--;
		//交换两个整数在数组中的位置
		if (i <= j){
			t=a[i];
			a[i]=a[j];
			a[j]=t;
			i++;
			j--;
		}
	}
	//利用递归继续排序
	if (left < j)quicksort(left,j);		//对基准数左边继续排序
	if (i < right)quicksort(i,right);	//对基准数右边继续排序
}

int main()
{
	ofstream outfile;
	outfile.open("int.txt");
	//处理异常
	if(!outfile){
		cout << "int.txt不存在" << endl;
	}

	cin >> n ;	//输入需要生成的随机数

	outfile << "以下共有 " << n << " 个数据进行排序" << endl;

	//随机生成整数
	for (int i = 1; i <= n; i++){
		a[i] = rand() % 10000000;
	}

	//输出排序前的整数
	outfile << "\n排序前的整数\n" << endl;
	for(int i = 1; i <= n; i++){
		cout << a[i] << " ";
		outfile << a[i] << " ";
	}
	cout << endl;

	//排序开始时间
	clock_t startime = clock();

	//调用递归排序函数
	quicksort(1,n);

	//线程随眠
	/*Sleep(1000);*/

	//排序结束时间
	clock_t endtime = clock();

	//输出排序后的整数
	outfile << "\n排序后的整数\n" << endl;
	for(int i = 1; i <= n; i++){
		cout << a[i] << " ";
		outfile << a[i] << " ";
	}
	cout << endl;

	//控制台输出时间
	printf("\n排序总时间-->>%fs\n",(double)(endtime - startime) / CLOCKS_PER_SEC);

	//文本输出时间
	outfile << "\n排序总时间-->>" << (double)(endtime - startime) / CLOCKS_PER_SEC << " s";

	//关闭文件流
	outfile.close();

	return 0;
}