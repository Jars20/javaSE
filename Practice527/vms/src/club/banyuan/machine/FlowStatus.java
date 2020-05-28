package club.banyuan.machine;

import java.io.Serializable;

public enum FlowStatus implements Serializable {
  ROOT,
  READ_PRODUCT_INFO,
  INSERT_COIN,
  PRESS_PRODUCT_BTN,
  PRESS_RETURN_BTN,
  /**
   * 输入用户名和密码
   */
  OPEN_SERVICE_MENU,
  /**
   * 显示管理员菜单
   */
  ADMIN_ROOT,
  ADMIN_INSPECT_STATUS,
  ADMIN_WITHDRAW_MONEY,
  ADMIN_REFILL_PRODUCT,
  ADMIN_CHANGE_PRODUCT,
  QUIT
}
