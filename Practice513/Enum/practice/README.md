
使用MONDAY，TUESDAY ...的常量创建一个公共枚举Weekday，直到星期日。
枚举应具有实例方法boolean isWeekDay（）和实例方法boolean isHoliday（）。 
isHoliday（）方法应返回isWeekDay（）的反面。

编写一个程序演示如何使用此枚举，该程序具有一个以“工作日”作为参数并根据“工作日”是否为假日打印消息的方法。
我们建议main方法循环遍历Weekday枚举中的所有值，并将它们作为参数发送给该方法。
提示：Java中的每个枚举都有一个静态values（）方法，该方法返回枚举中值的数组，因此您可以为此使用for-each-loop（增强的for循环）。
提示：每个枚举都有一个toString（）实现，该实现返回在枚举中声明的常量名称，例如“星期五”。使用右侧的展开使用链接，以查看建议的解决方案/答案。

Q 2
使用您的工作日班来调查枚举是否实现Comparable。
声明一个工作日坐= Weekday.SATURDAY;。
在Weekday.values（）上使用一个带有day作为循环变量的循环，并使用call day.compareTo（sat）打印出每个值，以及它是否小于，等于或大于sat，
请记住，compareTo（）方法返回一个int，使得负值表示该日期小于sat零，这意味着该日被视为等于sat（按顺序比较它们时），一个正值表示该日期大于sat。