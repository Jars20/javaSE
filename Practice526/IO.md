# 前置知识

* 类和对象基础
* 接口基础

# 课程说明

应用程序的最主要目的就是用来处理用户数据。计算机处理数据之前需要将数据读取到内存中，处理数据之后，需要将处理结果输出。输入和输出指的是以内存为中心。

IO指的是Input/Output

Input指从外部读入数据到内存，例如，把文件从硬盘读取到内存，利用网络从其他计算机中读取数据到内存等等。

Output指把数据从内存输出到外部，例如，把数据从内存写入到文件保存到硬盘，把数据输出到屏幕显示。

Java提供了很多用于IO操作的API，用来帮助程序员使用规范和统一的方式处理数据从外部到内存的传输。

Java IO API位于Java IO包`java.io`中。如果查看`java.io`包中的类，那么众多的选择可能会令人困惑。

本教程将概述基础的IO类，例举使用IO类来完成文件的相关操作，可以类比操作文件的方式使用这些类来完成其他的输入输出操作，比如从网络传输。

# 学习目标

- 理解流的概念
- 学会使用流相关的api进行文件IO的操作
- 能够利用文件操作读取配置文件

# JAVA IO

## IO流

应用程序面临IO设备是非常多样的，输入端可能是硬盘文件、网络文件、键盘等等，输出端可能是显示器、网络客户端、打印机等等，每种设备都有自己一些传输数据的标准。如果程序员在编写向某种设备输入输出的程序的时候，都要了解其传输标准针对这个标准编写代码，会大大的降低开发效率，并且程序的扩展性会变差。因此使用IO流这样的方式将读写规范化。使用输入流接口约定数据读取到内存的方式，使用输出流接口约定数据从内存输出的方式。程序开发者，只针对输入流和输出流的接口对象进行开发，其他的设备只需要提供将数据转换为输入流对象或从输出流接口对象读取数据的方式即可。

输入流和输出流对象约定，数据变为一串0和1的组合，每次从对象中依次读取或写入数据，直到数据全部写入或读取。这种将数据串行话的方式很像水管中的水流，因此把这种模式称为IO流(Stream)

## 字节流

IO流以byte（字节）为读写的最小单位，被称为字节流。在Java中，`java.io.InputStream`和`java.io.OutputStream`两个抽象类分别用来规范字节流的输入和输出。

## 字符流

为了提高读写效率，java还规范了按照`char`作为单位进行读写的方式，这种流称为字符流。在Java中，`java.io.Reader`和`java.io.Writer`两个抽象类分别用来规范字符流的输入和输出。

需要注意的是，一个字符根据编码格式不同，所占的字节数是不同的。比如"你好"这两个字符，在UTF-8编码下，是6个字节，在GBK编码（windows下默认字符编码）下是4字节。通常在指定字符流时，还会指定字符的编码方式。

# 文件操作

将文件中的数据读取到内存(输入)或者将内存中数据保存到文件(输出)需要考虑两方面。第一个是如何将硬盘中一个文件映射称为一个java对象，另一个是如何将这个文件对象转换成输入流和输出流，使用输入流和输出流的规范方法进行数据的读写。

## File 类

java中预定义了`java.io.File`类用来创建文件对象描述文件数据。使用File类提供的方法，可以访问基础文件系统，进行如下操作

- 检查文件或目录是否存在。
- 如果目录不存在，请创建一个目录。
- 读取文件的长度。
- 重命名或移动文件。
- 删除文件
- 检查路径是文件还是目录。
- 读取目录中的文件列表。

### 创建File对象

在对文件系统或File类进行任何操作之前，必须创建一个Java File 实例。这是创建Java File实例的示例：

```
File file = new File("input-file.txt");
```

Java File构造函数将File实例指向的文件的基础文件系统中的文件路径作为参数。请注意，文件或目录路径实际上不必引用现有文件或目录。如果没有，将不会从File构造函数中获取异常。Java File类还具有其他一些构造函数，可用于以File不同方式实例化 实例这里不做过多介绍。

File 构造方法传入的路径可以是绝对路径也可以是相对路径，如果是相对路径，通常是 Java 虚拟机的调用路径，也就是说我们使用`java`命令启动程序时所处的路径。

### 检查路径是文件还是目录

File对象可以指向文件或目录。通过调用对象的`isDirectory()` 方法来检查对象是否指向文件或目录。true代表File指向目录，否则是文件。这是一个简单的示例：

```
File file = new File("input-file.txt");
boolean isDirectory = file.isDirectory();
```

### 检查文件或目录是否存在

可以使用File `exists()`方法检查Java File对象引用的文件或目录是否存在。如下示例：

```
File file = new File("input-file.txt");
boolean fileExists = file.exists();
```

### 创建目录

如果File目录不存在，则可以使用Java 类创建目录。File 类包含的方法`mkdir()`和`mkdirs()` 用于这一目的。

如果调用`mkdir()`方法尚不存在，它会创建一个目录。这是通过Java File类创建单个目录的示例：

```
File file = new File("newdir");

boolean dirCreated = file.mkdir();
```

以上代码将创建一个名为newdir的目录。目录创建成功后返回true，否则返回false

在mkdirs()将级联创建多级目录，示例如下：

```
File file = new File("newdir/subdir");

boolean dirCreated = file.mkdirs();
```

示例将创建newdir然后在newdir目录下创建subdir。如果目录均创建成功，返回true，否则返回false。

### 文件长度

调用File类中 `length()`读取文件长度 ，如下 ：

```
File file = new File("input-file.txt");

long length = file.length();
```

### 重命名或移动文件或目录

要重命名（或移动）文件，调用File类中`renameTo()`方法。这是一个简单的示例：

```
File file = new File("input-file.txt");

boolean success = file.renameTo(new File("new-file.txt"));
```

该renameTo()方法还可用于将文件移动到其他目录。传递给该renameTo()方法的File可以位于任意路径下

renameTo()方法返回true表示重命名成功，返回false表示重命名失败例如文件打开，文件权限错误等。

### 删除文件或目录

调用delete()方法删除文件。如下：

```
File file = new File("input-file.txt");

boolean success = file.delete();
```

delete()方法返回boolean类型，指示删除是否成功。删除文件可能由于各种原因而失败，例如文件打开，错误的文件权限等。

delete()方法也适用于目录。

### 读取目录中的文件列表

可以通过调用`list()`方法或`listFiles()`方法来获取目录中所有文件的列表。`list()`方法返回一个String数组，其中包含File对象指向的目录中的文件名或目录名。listFiles() 返回的File数组代表在目录中的文件或目录。

这是一个通过Java File list()和listFiles() 方法列出目录中所有文件的示例：

```
File file = new File("data");

String[] fileNames = file.list();

File[]   files = file.listFiles();
```

## 读文件

文件读取，首先需要将文件转换成输入流对象，然后调用输入流的标准方法读取数据。

### FileInputStream

`java.io.FileInputStream`用于将文件转换为一个输入流对象。以下是使用FileInputStream读取文件内容的示例

```
try {
  FileInputStream fileInputStream  = new FileInputStream("input-file.txt");
  int data;
  do {
    data = fileInputStream.read();
    if (data != -1) {
      // 处理数据
    }
  } while (data != -1);
  fileInputStream.close();
} catch (IOException e) {
  e.printStackTrace();
}
```

`FileInputStream`是`InputStream`的一个子类，创建`FileInputStream`也可以写成如下形式

```
InputStream inputStream = new FileInputStream("input-file.txt");
```

### FileInputStream构造方法

FileInputStream构造方法接收文件的路径字符串作为参数。如下这是一个代码示例：

```
String path = "/Users/banyuan/thefile.txt";

FileInputStream fileInputStream = new FileInputStream(path);
```

除了使用路径作为参数，还可以使用File对象作为构造方法参数

```
String path = "/Users/banyuan/thefile.txt";
File   file = new File(path);
FileInputStream fileInputStream = new FileInputStream(file);
```

`FileInputStream`构造方法会抛出`FileNotFoundException`，这个异常是`IOException`的子类，是一个受查异常。我们上述的示例代码中catch中使用了IOException，可以捕获`FileNotFoundException`异常。

#### read

read()方法是InputStream中定义的抽象方法。FileInputStream中重写了这个方法。如果该read()方法返回-1，表示输入流中数据已经读取完毕，可以将其关闭，否则表示读取到一个byte所表示的数值。

FileInputStream还实现了InputStream中定义的read两个重载的抽象方法，可以将数据读入byte数组

```
int read(byte[])
int read(byte[], int offset, int length)
```

第一种方法将读取到的字节填充到byte数组中

第二种方法试图读取length长度的字节到byte数组中，并从数组的指定位置(offset)那里开始进行填充。

两种方法都返回实际读入byte数组的字节数。有可能读取的字节数少于数组中可容纳空间的字节数，或者少于length 参数中指定的字节数。如果 FileInputStream已经没有数据，则read()方法将返回-1。因此，有必要检查调用read()方法的返回的值。

这是调用read(byte[])方法之一的示例：

```
FileInputStream fileInputStream = new FileInputStream("input-text.txt");

byte[] data      = new byte[1024];
int    bytesRead = fileInputStream.read(data, 0, data.length);

while(bytesRead != -1) {
  doSomethingWithData(data, bytesRead);

  bytesRead = fileInputStream.read(data, 0, data.length);
}
```

请注意，`read(data, 0, data.length)`等效于`read(data)`。

通常一次读取一个字节数组比一次从Java读取单个字节速度要快。字节数组并不是越大速度越快，实际大小和取决于读取的字节数组的大小以及运行代码的计算机的操作系统，硬件等。

#### 关闭流

开启的输入流或输出流对象，在使用完毕后都需要被手动关闭。释放占用的内存和其他外部资源。

通过调用继承自InputStream的close方法关闭输入流

```
try {
  FileInputStream fileInputStream  = new FileInputStream("input-file");
  int data;
  do {
    data = fileInputStream.read();
    if (data != -1) {
      // 处理数据
    }
  } while (data != -1);
  fileInputStream.close();
} catch (IOException e) {
  e.printStackTrace();
}
```

上面的代码中，如果取数据时抛出异常，那么close()则永远不会被调用。为了解决这个问题，将必须使用finally关闭资源，这种方式在异常处理中已经提到过

```
    FileInputStream fileInputStream = null;
    try {
      fileInputStream = new FileInputStream("input-file");
      int data;
      do {
        data = fileInputStream.read();
        if (data != -1) {
          // 处理数据
        }
      } while (data != -1);
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        fileInputStream.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
```

这是一个FileInputStream使用try-with-resources结构关闭文件流的示例：

```
try(FileInputStream fileInputStream = new FileInputStream("input-file")) {
  int data;
  do {
    data = fileInputStream.read();
    if (data != -1) {
      // 处理数据
    }
  } while (data != -1);
} catch (IOException e) {
  e.printStackTrace();
}
```

请注意，FileInputStream在try关键字后的括号内声明了。这向Java发出信号，FileInputStream将由try-with-resources结构进行管理。

一旦try块中代码执行完毕，就将其FileInputStream关闭。如果从try块内部引发了异常，则捕获该异常，将 FileInputStream其关闭，然后重新抛出该异常。因此FileInputStream，当在try-with-resources块中使用时，可以确保将其关闭。

### BufferedInputStream

java.io.BufferedInputStream中，提供了一种带有缓冲区的从流读取数据的方式。BufferedInputStream首先将数据读取到内部的缓冲区中，调用BufferedInputStream中方法读取数据时，将首先从BufferedInputStream缓冲区读取数据。当缓冲区数据被读取完，BufferedInputStream将数据从外部读入缓冲区。这样可以减少从硬盘或网络获取数据的次数，提高读数据的效率

创建BufferedInputStream对象示例

```
BufferedInputStream bufferedInputStream = new BufferedInputStream(
                      new FileInputStream("input-file.txt"));
```

将要添加缓冲的InputStream对象包装在BufferedInputStream对象中。BufferedInputStream 内部创建了一个byte数组，并通过调用InputStream.read(byte[])方法填充这个数组。

可以设置BufferedInputStream中缓冲区大小。将大小作为BufferedInputStream构造函数的参数传入，如下所示：

```
int bufferSize = 8 * 1024;
    
BufferedInputStream bufferedInputStream = new BufferedInputStream(
                      new FileInputStream("input-file.txt"),
                      bufferSize
    );
```

本示例将所使用的内部缓冲区设置为8 KB。最好使用1024个字节的倍数的缓冲区大小，配合外设的外部缓冲区。

除了在输入流中添加缓冲外，BufferedInputStream其行为与完全相同InputStream。

#### mark（）和reset（）

mark和reset方法提供了可以反复读取流中数据的支持。InputStream中定义了两个抽象方法，其子类可以选择支持或不支持。如果InputStream子类支持mark()和reset()方法，则该子类应重写markSupported()返回 true。如果markSupported() 方法返回false，则表示子类不支持mark()和reset()。

调用mark()将在内部的标记的输入流当前读取的位置，流还是可以继续读取，调用reset()将使得数据流恢复至mark()标记时刻的状态。

并非所有InputStream 子类都支持这些方法。一般来说，你可以调用的markSupported()方法，以找出是否 mark()和reset()被支撑在一个给定的InputStream或没有，但 BufferedInputStream支持他们。

#### 关闭BufferedInputStream

BufferedInputStream同样需要在使用完成后手动关闭，关闭方式和InputStream类似。调用BufferedInputStream的close方法关闭流对象。 其中包裹的InputStream对象在BufferedInputStream被关闭后自动关闭。

这是一个BufferedInputStream使用try-with-resources构造关闭Java的示例：

```
try(BufferedInputStream bufferedInputStream =
        new BufferedInputStream( new FileInputStream("input-file.txt") ) ) {

    int data = bufferedInputStream.read();
    while(data != -1){
        data = bufferedInputStream.read();
    }
}
```

### InputStreamReader

可以使用 `java.io.InputStreamReader`读取文件的内容作为字符流。这样在处理文本内容的时候更加方便，按照顺序每次读入文本中的一个字符。InputStreamReader是Java Reader类的子类，

 InputStreamReader的类，包装了一个 InputStream，从将`InputStream`为基础的字节流转换为字符流Reader。换句话说，InputStreamReader将读取到的字节解释为文本而不是数字数据。

Java InputStreamReader通常用于从文件（或网络连接）中读取字符，其中字节表示文本。例如，一个字符编码为UTF-8的文本文件。您可以使用InputStreamReader来包装FileInputStream以读取此类文件。

```
InputStream inputStream       = new FileInputStream("input.txt");
Reader      inputStreamReader = new InputStreamReader(inputStream);

int data = inputStreamReader.read();
while(data != -1){
    char theChar = (char) data;
    data = inputStreamReader.read();
}

inputStreamReader.close();
```

本示例首先创建一个FileInputStream，然后将其包装在中InputStreamReader。

#### 构造方法

InputStreamReader在创建对象的时候，只允许使用inputStream对象基础上进行创建。构造方法中必须传入一个inputStream的对象。可以理解为InputStreamReader是在inputStream进行了扩充，这里使用了组合的方式，InputStreamReader对象内部包含了一个InputStream对象，来完成一些其他功能，这里没有使用继承，首先是因为InputStreamReader已经继承了Reader抽象类，另外不能把InputStreamReader理解为是一个InputStream。

#### 设置字符编码

InputStream将使用某些字符编码进行编码。这种字符编码在Java中称为字符集。两种常用的字符集是ASCII（或ISO-Latin1）和UTF8。

需要InputStreamReader对象设置了哪种编码字符集。可以在InputStreamReader构造函数中执行此操作。如下：

```
InputStream inputStream = new FileInputStream("data.txt");

InputStreamReader inputStreamReader =
    new InputStreamReader(inputStream, Charset.forName("UTF-8"));
```

可以通过调用InputStreamReader对象的getEncoding()方法获取获取字符编码 。如下

```
String encoding = inputStreamReader.getEncoding();
```

#### 读取数据

InputStreamReader中read方法同样返回一个int，其中包含读取的字符对应的数值。如下

```
int data = inputStreamReader.read();
char aChar = (char) data;
FileReader fileReader = new FileReader("input-text.txt");

char[] destination = new char[1024];

int charsRead = fileReader.read(destination, 0, destination.length);
```

另外可以使用该方法，将数据一次性读入到一个char数组中` read(char cbuf[], int offset, int length) `，这里数组的数据类型是char类型，而不再是byte类型。

```
FileReader fileReader = new FileReader("input-text.txt");

char[] destination = new char[1024];

int charsRead = fileReader.read(destination, 0, destination.length);
```

虽然read方法和inputStream一样，都是返回一个int，但是数据有本质区别，inputStream read返回的是1个byte转换成int的数值，因此最大值不会超过255。InputStreamReader读取到的内容，根据字符编码，可能是多个byte 转换成为的int的数值。

#### 关闭流

类似于其他流一样，InputStreamReader在使用完成后需要被关闭，同样调用close方法。关闭了InputStreamReader之后，会自动关闭内部的InputStream对象。

#### FileReader

FileReader是inputStreamReader的子类，FileReader中只是增加了一些新的构造方法，方便我们使用文件路径创建inputStreamReader对象。

```
FileReader fileReader = new FileReader("input-text.txt");

int data = fileReader.read();
while(data != -1) {
  data = fileReader.read();
}
```

InputStreamReader是没有传入文件路径作为参数的构造方法的。FileReader 进行了构造方法的扩展专门用来操作文件，其他的方法全部继承自InputStreamReader。

### BufferedReader

类似于BufferedInputStream， BufferedReader定义了带有内部缓冲区的字符流对象。

BufferedReader对象内部需要包装一个InputStreamReader的对象，需要在构造方法中传入。如下

```
BufferedReader bufferedReader = new BufferedReader(
                      new FileReader("input-text.txt"));
```

本示例创建一个BufferedReader包装了的FileReader。读取数据时，先BufferedReader对象内部缓冲区读取数据，直到缓冲区内容读取完之后，一次性从外部读取数据重新填满缓冲区

将size作为构造函数参数提供，BufferedReader缓冲区大小 您可以将缓冲区大小设置为在内部使用BufferedReader。

```
int bufferSize = 8 * 1024;

BufferedReader bufferedReader = new BufferedReader(
                      new FileReader("input-text.txt"),
                      bufferSize
);
```

本示例将内部缓冲区设置为8 KB。最好使用1024个字节的倍数的缓冲区大小。

除了具备缓冲区外，BufferedReader行为几乎类似于Reader。

#### read

BufferedReader 中read方法和inputStreamReader类似。

读数据到字符数组中的代码如下

```
Reader reader =
    new BufferedReader(
        new FileReader("/path/to/file/thefile.txt"));

char[] theChars = new char[128];

int charsRead = reader.read(theChars, 0, theChars.length);
while(charsRead != -1) {
    System.out.println(new String(theChars, 0, charsRead));
    charsRead = reader.read(theChars, 0, theChars.length);
}
```

BufferedReader有一个额外的方法readLine()方法。如果需要一次读取一行文本，则此方法很方便。这是一个BufferedReader readLine() 例子：

```
BufferedReader bufferedReader =
    new BufferedReader(
        new FileReader("/path/to/file/thefile.txt"));

String line = bufferedReader.readLine();
while(line != null) {
    System.out.println(line);
    line = bufferedReader.readLine();
}
```

#### 跳过字符

BufferedReader类具有一个名为skip()的方法，该方法可用于跳过不想读取的字符。将要跳过的字符数作为参数传递给skip()方法。如下

```
long charsSkipped = bufferedReader.skip(24);
```

此示例告诉Java BufferedReader跳过24个字符之后，再开始读取字符。该skip()方法返回跳过的实际字符数。在大多数情况下，该数字于请求跳过的字符数相同，但是如果剩余字符少于请求跳过的字符数，则返回剩余的字符数量

## 写文件

写文件，首先需要将内存中的数据转换为输出流对象，然后调用输出流的标准方法向输出流写入数据。数据会根据输出流对象的内部实现，写入到文件中。开发人员只需要考虑怎样向输出流写入数据即可。

### 输出流相关类

以上提到的每一个输入流类都有一个与之对应的输出流的类。

字节流
InputStream - OutputStream
FileInputStream - FileOutputStream
BufferedInputStream - BufferedOutputStream

字符流
Reader - Writer
InputStreamReader - OutputStreamWriter
BufferedReader - BufferedWriter

输出流对应类的构造方法和关闭方法和输入流对应对象类似，不再进行冗余的介绍。

### 文件覆盖和追加

FileOutputStream 提供了新的构造方法，可以决定是要覆盖现有文件，还是要追加到现有文件。可以根据、选择使用哪个构造方法来决定。

仅使用一个参数（文件名）的此构造方法将覆盖任何现有文件：

```
OutputStream output = new FileOutputStream("output-text.txt");
```

还有一个构造方法要两个参数：文件名和一个boolean值。boolean指示是否附加到文件。因此，值为 true表示要附加到文件，而值为false表示要覆盖文件。这是两个Java FileOutputStream构造函数示例：

```
OutputStream output = new FileOutputStream("output-text.txt", true); //append

OutputStream output = new FileOutputStream("output-text.txt", false); //overwrite
```

当省略第二个参数，默认模式是覆盖给定路径上的任何现有文件。

### 写入文件内容

将数据写入到输出流，就代表了数据写入到了文件中。

#### 使用字节流写文件

调用其中的write()方法。write()方法接收一个int参数，其中包含要写入字节的值。因此，传递的int值的二进制数值只有低8位数据有效。示例如下：

```
OutputStream outputStream = new FileOutputStream("output-text.txt");

outputStream.write(123);
```

写入字节数组

```
OutputStream outputStream = new FileOutputStream("output-text.txt");

byte bytes =  new byte[]{1,2,3,4,5};

outputStream.write(bytes);
```

带有缓冲区的写入

```
BufferedOutputStream bufferedOutputStream =
    new BufferedOutputStream(new FileOutputStream("output-text.txt"));

bufferedOutputStream.write(123);
BufferedOutputStream bufferedOutputStream =
    new BufferedOutputStream(new FileOutputStream("output-text.txt"));

byte bytes =  new byte[]{1,2,3,4,5};

outputStream.write(bytes);
```

#### 使用字符流写文件

```
FileWriter fileWriter = new FileWriter("output.txt");

fileWriter.write('A');
FileWriter fileWriter = new FileWriter("output.txt");

char[] chars = new char[]{'A','B','C','D','E'};
fileWriter.write(chars);
int bufferSize = 8 * 1024;
    
BufferedWriter bufferedWriter = 
    new BufferedWriter(
        new FileWriter("output-file.txt"),
            bufferSize);
char[] chars = new char[]{'A','B','C','D','E'};
bufferedWriter.write(chars);
```

### flush（）

调用write方法将数据写入到输出流之后，数据从输出流写入到硬盘的时候，可能会出现延迟的情况。数据可能会在内部缓存在计算机内存中，并在之后某个时间（例如写入数据数量到达某个固定的值，或输出流被关闭）写入硬盘。

如果要确保所有写入的数据立即写入外部设备，可以调用其flush()方法。调用flush()将确保到目前为止已写入的所有数据完全写入外部设备。如下：

```
OutputStream outputStream = new FileOutputStream("output-text.txt");

byte bytes =  new byte[]{1,2,3,4,5};

outputStream.write(bytes);

outputStream.flush()
```