#include<iostream>
#include<cstdlib>	//生成随机数头文件
#include<ctime>		//时间头文件
#include<Windows.h>
#include<fstream>
using namespace std;

int a[10],b[100],n;

//统计每个整数出现次数
void countNum()
{
	for (int i = 1; i <= n; i++){
		for (int j = 1; j <= n; j++){
			if (a[i] == a[j]){
				b[a[i]]++;
			}
		}
	}
}

int main()
{
	cin >> n;

	for (int i = 0; i < n; i++)
	{
		a[i] = rand() % 10;
	}

	for (int i = 0; i < n; i++)
	{
		cout << a[i] << " ";
	}
	cout << endl;

	countNum();

	for (int i = 0; i < sizeof(b); i++)
	{
		if (b[i] != 0)
		{
			cout << i << " : " << b[i] << endl;
		}
	}
	cout << endl;

	return 0;
}