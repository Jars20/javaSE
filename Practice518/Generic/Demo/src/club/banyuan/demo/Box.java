package club.banyuan.demo;

public class Box<AnyType> {

  private Object item;
  private AnyType anyTypeItem;

  public AnyType getAnyTypeItem() {
    return anyTypeItem;
  }

  public void setAnyTypeItem(AnyType anyTypeItem) {
    this.anyTypeItem = anyTypeItem;
  }

  public Object getItem() {
    return item;
  }

  public void setItem(Object item) {
    this.item = item;
  }

  public static void main(String[] args) {
    Box<Item> box = new Box<>();
    Box<OtherItem> box1 = new Box<>();
    Box<Integer> boxes = new Box<>();
    // boxes.setAnyTypeItem(1);

    // Box<int> box2 = new Box<>();

    // Box<Item> box1 = new Box();

    // box.setItem(new OtherItem());
    // box.setItem(new Item());
    // Object item = box.getItem();
    //
    // box.setAnyTypeItem(new Item());
    // box.setAnyTypeItem(new OtherItem());
    // Item anyTypeItem = box.getAnyTypeItem();
    //
    // Box<OtherItem> otherItemBox = new Box<>();
    // otherItemBox.setAnyTypeItem(new OtherItem());
    // otherItemBox.setAnyTypeItem(new Item());



    // Object item = box.getItem();
    //

    // Box<Item> boxItem = new Box<>();
    // boxItem.setItem(new Item());
    // Item item = boxItem.getItem();

  }
}
