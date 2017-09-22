/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cobaarraylist;

/**
 *
 * @author Zero-Inside
 */
public class InnerClass {
    private int data = 30;

    public class nestedClass {
        public void msg() {
            System.out.println("data is " + data );
        }     
    }
    
    void display() {
        nestedClass nest = new nestedClass();
        nest.msg();
    }
}
