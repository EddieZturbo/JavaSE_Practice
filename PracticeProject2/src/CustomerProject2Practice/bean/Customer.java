package CustomerProject2Practice.bean;

/**
 * @author shkstart
 * @create 2022-07-30 9:21
 */
//创建类 设计类的成员
public class Customer{
        //设计类的属性
        private String name;//客户姓名
        private char gender;//姓别
        private int age;//年龄
        private String phone;//电话
        private String email;//电子邮箱

        //设计类的constructor方法

        public Customer() {
        }

        public Customer(String name, char gender, int age, String phone, String email) {
                this.name = name;
                this.gender = gender;
                this.age = age;
                this.phone = phone;
                this.email = email;
        }
        //设计类的方法

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public char getGender() {
                return gender;
        }

        public void setGender(char gender) {
                this.gender = gender;
        }

        public int getAge() {
                return age;
        }

        public void setAge(int age) {
                this.age = age;
        }

        public String getPhone() {
                return phone;
        }

        public void setPhone(String phone) {
                this.phone = phone;
        }

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }
}
