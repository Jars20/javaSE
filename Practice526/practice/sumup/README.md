 1. 编写一个包含两个公共静态方法的IOStrings类：
* String [] loadArray(InputStream is,int[] n)
循环n，依次读取每个n下标的数值，根据这个数值读取is中数据，将得到的结果生成字符串，将所有的字符串组成的数组返回。
如果在n循环结束前is读取结束，则抛出RuntimeException标识读取失败
* void saveArray（OutputStream os，String [] sa）
将字符串数组sa循环写入os。

2. 编写一个公共静态方法，接收一个文件路径和整数n，文件中写入大小为n的乘法表。例如，对于n=3，该方法应
写入：
1 2 3
2 4 6
3 6 9

