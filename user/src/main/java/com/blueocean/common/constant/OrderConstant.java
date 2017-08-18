package com.blueocean.common.constant;

public class OrderConstant {
	
	public static interface OrderType {
		/** 订单类型   自送  0 */
		public final static int SelfSend = 0;
		/** 订单类型  上门  1 */
		public final static int  Deliver = 1;

	}
	
	public static interface OrderStatus {
		/** 订单状态   待回收   0 */
		public final static int WaitRecovere = 0;
		/** 订单状态   已完成   1 */
		public final static int  Finished = 1;
		/** 订单状态   已关闭   2*/
		public final static int  Closed = 2;

	}

}
