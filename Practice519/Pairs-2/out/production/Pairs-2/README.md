1. 根据注释完成maximumStadium方法，提供合适的测试类以确保其按预期工作。
2. 创建名为Pair的ObjectPair类的副本。使用Java泛型重构此类。更新后的类应使可以独立指定第一个和第二个元素的类型。
创建名为PairDriver的ObjectPairDriver类的副本。重构此类让其可以使用新的Pair类。功能保持不变。代码不应包含任何强制转换操作。
3. 声明一个使用泛型的Pair对象的固定大小的数组。根据需要声明其他成员，以跟踪添加的对的数量。
完成构造函数。不可直接实例化Java中的通用对象数组。
这将无法编译：pair = new Pair <K，V> [CAPACITY];
在这种情况下，最简单的解决方案是分配一个“原始”对数组：pair = new Pair [CAPACITY];
这将导致以下警告：“类型安全：Pair []类型的表达式需要未经检查的转换才能符合Pair []”，
可以使用@SuppressWarnings（“ unchecked”）注释将其抑制。注意：绝大多数禁止警告是错误的想法。这是一个罕见的例外。完成addPair方法。如果数组已满，则返回false。实现所需的Iterator方法。要删除该对，应删除该对，并且所有剩余元素应移到左侧一个位置。
