许多网站都根据他人喜欢的物品组合来推荐书籍和电影。
例如，如果张三喜欢"速度与激情"和"see you again"，而李四喜欢“see you again”，
则系统可能会建议Joe观看“速度与激情”。 我们的目标是创建一个具有两个功能的推荐系统： 
（a）对于给定的用户，它可以产生一组他们喜欢的项目； 
（b）给定一个项目，它可以产生一组用户可能会喜欢的其他项目。 
实现： PersonalRecommendor类包含一个名为Likes的HashMap，该HashMap将人的名字作为key，
映射到项目的（书，电影，歌曲等）名称的List。使用LinkedList类作为实现类。使用适当的访问修饰符可防止另一个类直接访问或编辑Likes。
 添加addLikes方法，该方法接收一个人的名字和一个项目的名称，并将该项目添加到该人的List集合中。 添加likesBoth方法，该方法接收一个人的名字和两个项目的名称，并返回一个布尔值，表示该人是否喜欢这两个项目。如果HashMap中没有给定名称的人，likesBoth应该抛出UnknownPersonException以报告未找到该人。 添加recommendByPerson方法，该方法接收一个人名作为参数，返回项目的List 添加recommendByProject方法，该方法接收一个项目名作为参数，返回项目的List，该List中的项目是所有Likes中包含的人中包含有给定项目名称的其他项目的集合 为上述方法的类创建一个Recommender接口，PersonalRecommendor作为实现类。并添加相应的测试方法。