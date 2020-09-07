import java.util.Scanner;

import java.util.regex.Pattern;
import java.io.File;
class Cls_ctrbtr
{
  public String dsp_nme;
  public String dsp_plce;
  public String dsp_ctry;
  public String dsp_num;
  public double ctbr;
  public int id;
  public Cls_ctrbtr(String dsp_nme, String dsp_plce, String dsp_ctry, String dsp_num, double ctbr, int id)
  {
    this.dsp_nme = dsp_nme;
    this.dsp_plce = dsp_plce;
    this.dsp_ctry = dsp_ctry;
    this.dsp_num = dsp_num;
    this.ctbr = ctbr;
    this.id = id;
  }
  public void printCls_ctrbtr(){
    System.out.println("Name: " + dsp_nme);
    System.out.println("City: " + dsp_plce);
    System.out.println("Country: " + dsp_ctry);
    System.out.println("Phone: " + dsp_num);
    System.out.println("Contribution: " + ctbr);
    System.out.println("ID: " + id);
    System.out.println();
  }
}

class Node{
  Cls_ctrbtr c;
  Node next;
  public Node(Cls_ctrbtr data){
    c = data;
    next = null;
  }
  public void displayNode(){
    c.printCls_ctrbtr();
  }
  void setNext(Node next){
    this.next = next;
  }
  Node getNext(){
    return this.next;
  }
}
class Stack{
  Node link_fst;
  public Stack(){
    link_fst = null;
  }
  public void push(Node newNode){
    if (link_fst == null)
    link_fst = newNode;
    else{
      newNode.setNext(link_fst);
      link_fst = newNode;
    }
  }
  public Node pop(){
    if (link_fst == null)
    return null;
    else if (link_fst.getNext() == null){
      Node t = link_fst;
      link_fst = null;
      return t;
    }
    else{
      Node t = link_fst;
      link_fst = link_fst.getNext();
      return t;
    }
  }
  public void print(){
    Node dsp = link_fst;
    while (dsp != null){
      dsp.displayNode();
      dsp = dsp.next;
    }
    System.out.println();
  }
}
class Main{
  public static void main(String[] args){
    Scanner fle_inp = null;
    String dsp_nme = null;
    String dsp_plce = null;
    String dsp_ctry = null;
    String dsp_num = null;
    double ctbr = 0;
    int id = 0;
    Cls_ctrbtr c = null;
    Stack stack = new Stack();
    Node node = null;
    try{
      fle_inp = new Scanner(new File("file.csv"));
      fle_inp.useDelimiter(Pattern.compile("(\\n)|(\\r)|,"));
    }
    catch(Exception e){
      System.err.println("Error opening file.");
    }
    while (fle_inp.hasNextLine()){
      String line = fle_inp.nextLine();
      String[] tpp = line.split(",");
      dsp_nme = tpp[0];
      dsp_plce = tpp[1];
      dsp_ctry = tpp[2];
      dsp_num = tpp[3];
      ctbr = Double.parseDouble(tpp[4]);
      id = Integer.parseInt(tpp[5]);
      c = new Cls_ctrbtr(dsp_nme, dsp_plce, dsp_ctry, dsp_num, ctbr, id);
      node = new Node(c);
      stack.push(node);
    }
    fle_inp.close();
    stack.pop();
    stack.print();
  }
}
