
#### 1. 为二进制字符串开发正则表达式
```
应该匹配成功
0
1
00
10
111010101010111
应该匹配失败
cat
123
he110, w0r1d
```
> A: ^[01]+$
#### 2. 为任何表示偶数的无符号二进制字符串开发一个正则表达式
```
应该匹配成功
0
10
1110
010
00011000110110
应该匹配失败
1
011
0101
0001101
```
>A: ^[01]*0$

# 长度为偶数
#### 3. 为任何偶数长度的二进制字符串开发正则表达式
```
应该匹配成功
00
01
1010
0001
0001101100011011
应该匹配失败
0
1
111
010
0001101
```
>A: ^(1(0|1)|0(1|0))*$


#### 4. 为任何包含模式0110或模式1001的二进制字符串开发一个正则表达式
```
应该匹配成功
0110
1001
01101001
011001
111101101111
0000010010000
应该匹配失败
0
1
0101
1010
1100010001110
```
>A:^[01]*(1001|0110)[01]*$

# 同时包含
#### 5. 为任何包含模式0110和模式1001的二进制字符串开发正则表达式(同时包含)
```
应该匹配成功
01101001
000110001001000
011001
100110
000011001000
应该匹配失败
0
1
0110
1001
01101
10010
1100010001110
```
>A:^[01]*(1001)[01]*(0110)[01]*|[01]*(100110)[01]*|[01]*(011001)[01]*|[01]*(0110)[01]*(1001)[01]*$

#### 6. 识别以下几个正则表达式表示的字符串类型，并给出一些测试字符串（包括匹配成功和匹配失败的例子各3个）:

```
[A-Z][0-9][A-Z]\s[0-9][A-Z][0-9]
([0-9]|[A-F])+
(\(\d\d\d\)\s)?\d\d\d-\d\d\d\d
```
>A: A9A 9A9 
>B: AFAFFAFAFFAF
>C: (123) 323-2313
#### 7. 开发一个正则表达式，它将接受以下三个字符串: {"pickup truck", "pick up truck", "pick-up truck"}

```
应该匹配成功
pickup truck
pick up truck
pick-up truck
应该匹配失败
pickuptruck
pick.up.truck
pick- up truck
pick -up truck
volkswagon
```
>A: ^pickup truck|pick up truck|pick-up truck$

#### 8. 开发一个正则表达式，它可以接受三个或四个单词

```
应该匹配成功
one two three
one two three four
1 2 3 4
how many words?
应该匹配失败
word
word word
word word word word word
```
>A:^\S+ \S+ \S+( \S+)?$

#### 9. 开发一个正则表达式，匹配24小时格式的时间字符串(0:00…23:59)
应该匹配成功
12:34
0:00
23:59
9:00
10:00
11:11
15:15
应该匹配失败
24:00
0:60
9:99
04:00
4
-4:00
>即求0-24的表示方法
>A:^(1?\d|2[0-3]):([0-5][0-9])$

# 表示三的倍数
#### 10. 
DNA序列由符号{A,C,G,T}组成。三个连续的字母被称为密码子，所以ACT和TCG都是密码子。一个基因组合至少包含三个密码子，它们以ATG密码子开始，以TAA、TAG或TGA密码子结束。

开发一个正则表达式来匹配基因字符串。
```
应该匹配成功
ATGCCCTAA
ATGCCCTAG
ATGCCCTGA
CATGCCCTAA
CATGCCCTAG
CATGCCCTGA
CATGCCCTAAC
CATGCCCTAGC
CATGCCCTGAT
TCATGCCCTGACC
TTATGCCCGGGTGACC
AAACTCATGCCCGGGCCCTGACCTTAA
ATGATGATGTAA
ATGAAAAACAAGAATTAA
ATGACAACCACGACTTAA
ATGAGAAGCAGGAGTTAA
ATGATAATCATGATTTAA
ATGCAACACCAGCATTAA
ATGCCACCCCCGCCTTAA
ATGCGACGCCGGCGTTAA
ATGCTACTCCTGCTTTAA
ATGGAAGACGAGGATTAA
ATGGCAGCCGCGGCTTAA
ATGGGAGGCGGGGGTTAA
ATGGTAGTCGTGGTTTAA
ATGTACTATTCATCCTCGTCTTGCTGGTGTTTATTCTTGTTTTAA
应该匹配失败
GATTACA
ATGTAA
ATGTAG
ATGTGA
ATGCCCCTAG
ATGCCCCCTAG
CCCATGCCCCTAGCCC
CCCATGCCCCCTAGCCC
```
> A:^[ACTG]*ATG([ACTG]{3})+(TAA|TAG|TGA)[ACTG]*$

# 带逗号和不带逗号的两种情况
#### 11. 开发匹配金额的正则表达式。

```
应该匹配成功
$0
$0.00
$0.99
$4
$4.00
$10
$10.00
$1000
$1000.00
$1,000
$1,000.00
$8,888,888,888,888.88
$88,888,888,888,888.88
$888,888,888,888,888.88
$1234567.89
应该匹配失败
$-0
$ 0
$1.9
$.99
bannana
$,333.33
$12,34
$22,333,22,333.22
$$$
$$$0
3$
```
>^\$([0-9]+|([0-9]{1,3})(,[0-9]{3})*)\.?(\d\d)?$

#### 12. 
我们准备在市场上买一辆红色的卡车,所以想开发一个自动化web搜索程序，搜索各种网上新闻组和分类广告网站找到文本包含red、truck的语句, 还要包含价格信息。

具体来说，单词red和短语(pickup/pick-up/pick up) truck中间最多出现两次其他单词。pick up truck 短语可以出现在red之前或之后。
在red和pickup truck之后，文本还应该包含价格

编写一段代码，将价格提取出来返回，测试代码时，将target 的list中保存所有测试成功和失败的字符串，然后传入方法中
```
public static List<Integer> getTruckPriceList(List<String> target);
```

```
应该匹配成功
red pickup truck $5000
red pickup truck $5,000
red pickup truck $1,234.56
red pick-up truck $5000
red pick up truck $5000
red toyota pick-up truck $5000
red toyota 1993 pick-up truck $5000
blah blah red toyota 1993 pick-up truck blah blah $5000 blah
pickup truck red $5000
pick-up truck 1993 toyota red $5000
blah blah blah pick-up truck toyota 1993 red blah blah blah $5000
desperate: red 1993 toyota pickup truck for sale. $2,000 o.b.o.
toy pickup truck - cherry red: $12.
red red pickup pickup truck truck $5000.
应该匹配不成功
red
truck
pickup truck
red pickup truck
red $5000
pickup truck $5000
red truck $5000
$5000 red pickup truck
blue pickup truck $5000
red car $5000
red toyota 1993 pick-up truck
red 1993 toyota automatic pick-up truck $5000
fred's pick-up truck sold for $5000
pick-up trucks by fred: $5000
reddy for sale pickup truck: $5000)
```

> A:^(.*red( \S*)?( \S*)?( pickup| pick-up| pick up) truck.*(\$[0-9]+|\$[0-9]{1,3}(,[0-9]{3})*).*)|
>(.*(pickup|pick up|pick-up) truck( \S*)?( \S*)? red.*(\$[0-9]+|\$[0-9]{1,3}(,[0-9]{3})*).*)$