import java.util.Scanner;

public class Num2 {
      private Scanner scanner;
      LinkedList L = new LinkedList();
      public void num2() {
         while (true) {
            System.out.print("(1) 전화번호 추가 (2) 전화번호 삭제 : ");
            Scanner s = new Scanner(System.in);  
            int k = s.nextInt();
            s.nextLine();
            switch (k) {
            case 1 :
               L.insertLastNode();
               L.printList();
               break;
            case 2 :
               System.out.print("삭제할 이름 : ");
               String del = s.next();
               boolean pre = L.searchNode(del); 
               if (pre == false)  {
                  System.out.println("검색 실패");
               } 
               else if(pre == true) {
                  L.deleteNode(del);
                  L.printList();
               }
               break;
            default : 
               System.out.println("다시 입력하세요.");
               break;
            }
            }
         }


class LinkedList {
   private ListNode head;
   public LinkedList() {
      head = null;
}

   public void insertLastNode() {
         System.out.print("이름 : ");
         Scanner s = new Scanner(System.in);
         String name = s.next();
          System.out.print("전화번호 : ");
          String num = s.next();
          System.out.print("이메일 주소 : ");
          String address = s.next();
		// 이름, 전화번호, 이메일 주소를 키보드로 입력받음
      ListNode newNode = new ListNode(name, num, address);
      if (head == null) {
         this.head = newNode;
      } // 데이터가 존재하지 않을 경우 newNode를 head로 설정
      else {
         ListNode temp = head;
         while (temp.link != null) temp = temp.link;
         temp.link = newNode;
		// 이미 데이터가 존재했을 경우 한 칸씩 이동
      }
   }
   
       public void deleteNode(String data) { 
          ListNode temp = this.head;
          if (head == null) {
               System.out.println("등록되어 있는 전화번호가 없어 삭제할 수 없습니다.");
            } //아무 데이터도 없을 경우
          else if (head.link == null) {
             if (data.equals(head.getData())) {
                 head = null;
             	System.out.println("삭제되었습니다.");
             } 
             else
            	 System.out.println("해당하는 전화번호가 없습니다.");
          } //데이터가 한 개만 있을 경우
          else {
        	  ListNode prev=head;
        	  ListNode curr=head.link;
             while (prev.link!= null) {
                if (data.equals(curr.getData())) {
                   prev.link = curr.link;
                   System.out.println("삭제되었습니다.");
                   break;
                }
                else {
                	prev=curr;
                	curr=curr.link;
			// 현재의 값과 입력받은 data가 일치하지 않을 경우 한 칸 이동해서 다시 시도
                }
          }
          }
       }
   public boolean searchNode(String name) {
      ListNode temp = this.head;
      while (temp != null) {
         if (name.equals(temp.getData()))
            return true;
         else temp = temp.link;
      }
      return true;
   }
   
    public void printList() {
         ListNode temp = this.head;
         while (temp != null) {
           System.out.print("이름 : " + temp.getData());
            System.out.print("  전화번호 : " + temp.getNum());
            System.out.print("  이메일 주소 : " + temp.getAddress());
            temp = temp.link;
            System.out.println();
            }
         }
      }

class ListNode {
   private String name, num, address;
      public ListNode link;
      public ListNode() {
         this.name = null;
         this.num = null;
         this.address = null;
         this.link = null;
      }
      public ListNode(String name, String num, String address) {
         this.name = name;
         this.num = num;
         this.address = address;
         this.link = null;
      }
      public ListNode(String name) {
          this.name = name;
          this.link = null;
       }
       public ListNode(String name, ListNode link) {
          this.name = name;
          this.link = link;
       }

      public String getData() {
         return this.name;
      }
      public String getNum() {
         return this.num;
      }
      public String getAddress() {
         return this.address;
      }
}

public static void main(String[] args) {
    Num2 pb = new Num2();
    pb.num2();
	// 실행
 }
}