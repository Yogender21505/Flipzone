import java.lang.reflect.Array;
import java.util.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class FLIPZON {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);

        ArrayList<Category> allcategory = new ArrayList<>();
        ArrayList<Giveaway> allgiveaway = new ArrayList<>();
        ArrayList<Customer> allcustomer= new ArrayList<>();

        int op1 = 0;
        Category category= new Category();
        do {

            System.out.println("WELCOME TO FLIPZON");
            System.out.println("    1) Enter as Admin");
            System.out.println("    2) Explore the Product Catalog");
            System.out.println("    3) Show Available Deals");
            System.out.println("    4) Enter as Customer");
            System.out.println("    5) Exit the Application");

            op1 = Integer.parseInt(input.nextLine());
            
            if (op1 == 1) {
                System.out.println("Dear Admin");
                System.out.println(" ");
                System.out.println("Please enter your username and password");

                String Username = input.nextLine();
                String Password = input.nextLine();
                String[] firstname = null;

                firstname = Username.split(" ");
                if (Username.compareTo("") == 0 && Password.compareTo("") == 0) {
                    int op2 = 0;
                    do {
                        System.out.println("WELCOME " + firstname[0] + "!!!!");
                        System.out.println("Please choose any one of the following actions:");
                        System.out.println("    1) Add category");
                        System.out.println("    2) Delete category");
                        System.out.println("    3) Add Product");
                        System.out.println("    4) Delete Product");
                        System.out.println("    5) Set Discount on Product");
                        System.out.println("    6) Add giveaway deal");
                        System.out.println("    7) Back");

                        op2 = Integer.parseInt(input.nextLine());
                        
                        if (op2 == 1) {
                            int id;
                            int newid = -1;

                            do {
                                System.out.println("Add category ID");

                                id = Integer.parseInt(input.nextLine());

                                for (int i = 0; i < allcategory.size(); i++) {
                                    if (allcategory.get(i).getID() == id) {
                                        System.out.println(
                                                "Dear Admin, the category ID is already used!!! Please set a different and a unique category ID");
                                        newid = 0;
                                    }
                                }
                                if (newid == 0) {
                                    newid = -1;
                                }
                                else {
                                    newid=1;
                                }

                            } while (newid != 1);

                            String catname;
                            int newcatname = -1;

                            do {
                                System.out.println("Add name of the category");
                                catname = input.nextLine();

                                for (int i = 0; i < allcategory.size(); i++) {
                                    if (allcategory.get(i).getnamecat().compareTo(catname)==0) {
                                        System.out.println(
                                                "Dear Admin, the category Name is already used!!! Please set a different and a unique category Name");
                                        newcatname = 0;
                                    }

                                }
                                if (newcatname == 0) {
                                    newcatname = -1;
                                }
                                else{
                                    newcatname=1;
                                }


                            } while (newcatname != 1);
                            Category cate = new Category(id, catname);
                            allcategory.add(cate);
                            cate.AddData(allcategory);
                            category=cate;
                        }

                        if (op2 == 2) {
                            System.out.println("Enter the Name of Category");
                            String cat=input.nextLine();
                            for (int i=0;i<allcategory.size();i++){
                                if (cat.compareTo(allcategory.get(i).getnamecat())==0){
                                    allcategory.remove(i);

                                    break;
                                }
                            }
                        }

                        if (op2 == 3) {
                            int Entercatid=Integer.parseInt(input.nextLine());
                            int i=0;
                            for (i=0;i<allcategory.size();i++){
                                if (Entercatid==allcategory.get(i).getID()){
                                    break;
                                }
                            }
                            System.out.println(allcategory.get(i).getnamecat());


                            category.AddData(i,allcategory);

                        }
                        if (op2 == 4) {
                            System.out.println("Enter the Product ID : ");
                            Double id=Double.parseDouble(input.nextLine());
                            for (int i=0;i<allcategory.size();i++){
                                for (int j=0;j<allcategory.get(i).getsizeofPID();j++){
                                    if (allcategory.get(i).allPid.get(j).Pid().equals(id)) {
                                        allcategory.get(i).allPid.remove(j);
                                        allcategory.get(i).allPrice.remove(j);
                                        allcategory.get(i).allquantity.remove(j);
                                        allcategory.get(i).allpdiscount.remove(j);
                                        allcategory.get(i).alldata.remove(j);
                                        break;
                                    }
                                }

                            }


                        }
                        if (op2 == 5) {
                            category.setDiscount(allcategory);
                        }
                        if (op2 == 6) {
                            Giveaway giveaway=new Giveaway();
                            giveaway.Addgiveaway(allgiveaway, allcategory);
                        }

                    } while (op2 != 7);
                } else {
                    System.out.println("Incorrect Details are Provided, Please Try again");
                }

            }
            if (op1 == 2) {

                category.Getcatalog(allcategory);

            }
            if (op1 == 3) {
                Giveaway getgiveawata=new Giveaway();
                getgiveawata.Getgiveaway(allgiveaway);

            }
            if (op1 == 4) {
                int op4=0;
                
                do{
                    System.out.println("1) Sign up");
                    System.out.println("2) Log in");
                    System.out.println("3) Back");
                    op4=Integer.parseInt(input.nextLine());

                    Customer custom=new Customer();
                    if (op4==1){
                        System.out.println("Enter Name");
                        String name= input.nextLine();
                        System.out.println("Enter Password");
                        String password=input.nextLine();
                        Customer customer=new Customer(name,password);
                        allcustomer.add(customer);
                        custom=customer;
                    }
                    
                    if (op4==2){
                        System.out.println("Enter Name");
                        String name= input.nextLine();
                        System.out.println("Enter Password");
                        String password=input.nextLine();
                        int i=0;
                        for (i=0;i<allcustomer.size();i++){
                            if (allcustomer.get(i).Name().equals(name) && allcustomer.get(i).Password().equals(password)){
                                break;
                            }
                        }
                        int option=0;
                        
                        do{
                            System.out.println("Welcome "+allcustomer.get(i).Name());
                            System.out.println("    1) browse products");
                            System.out.println("    2) browse deals");
                            System.out.println("    3) add a product to cart");
                            System.out.println("    4) add products in deal to cart");
                            System.out.println("    5) view coupons");
                            System.out.println("    6) check account balance");
                            System.out.println("    7) view cart");
                            System.out.println("    8) empty cart");
                            System.out.println("    9) checkout cart");
                            System.out.println("    10) upgrade customer status");
                            System.out.println("    11) Add amount to wallet");
                            System.out.println("    12) back");
                            option=Integer.parseInt(input.nextLine());
                            
                            if(option==1){
                                System.out.println("----------Browse Products-----------");
                                System.out.println("\n");
                                for (int o=0;o<allcategory.size();o++){
                        
                                    String ans="";
                                    System.out.println("Category name: "+allcategory.get(o).getnamecat());
                                    for (int j=0;j<allcategory.get(o).getsizeofPID();j++){
                                        ans=allcategory.get(o).alldata.get(j).data();
                                        System.out.println("Product Name "+allcategory.get(i).allProductname.get(j).Productname());
                                        System.out.println("Product Price "+allcategory.get(o).allPrice.get(j).price());
                                        System.out.println("Product ID "+allcategory.get(o).allPid.get(j).Pid());
                                        System.out.println("Product Quantity "+allcategory.get(o).allquantity.get(j).getQuantity());
                                        System.out.println(ans);
                                    }
                        
                                }
                                
                            }
                            if(option==2){
                                custom.Browsedeals(i,allgiveaway,allcustomer);
                            }
                            if(option==3){
                                    custom.addproducttocart(i, allcustomer,allcategory);

                            }
                            if(option==4){
                                System.out.println("Enter the first Product ID :");
                                Double Enter1stPID=Double.parseDouble(input.nextLine());
                                System.out.println("Enter the second Product ID:");
                                Double Enter2ndPID=Double.parseDouble(input.nextLine());

                                custom.Adddeal(Enter1stPID,Enter2ndPID,i,allcustomer,allgiveaway);
                                

                            }
                            if(option==5){
                                
                                for (int l=0;l<allcustomer.get(i).coupons.size();l++){
                                    System.out.println("Coupon "+(l+1) +" "+allcustomer.get(i).coupons.get(l));
                                }
                                
                            }
                            if(option==6){
                                System.out.println("Current account balance is Rupees "+allcustomer.get(i).amount());
                            }
                            if(option==7){
                                        System.out.println("-----------My Cart-----------");
                                    
                                if (allcustomer.get(i).ProductId.size()>0){

                                for (int j=0;j<allcustomer.get(i).ProductId.size();j++){
                                    for (int k=0;k<allcategory.size();k++){

                                        for (int l=0;l<allcategory.get(k).allPid.size();l++){
                                            if(allcategory.get(k).allPid.get(l).Pid().equals(allcustomer.get(i).ProductId.get(j).Pid())){
                                                for (int o=0;o<allcategory.get(k).allpdiscount.size();o++){
                                                    System.out.println("product name :"+ allcategory.get(k).allProductname.get(o).Productname());
                                                    System.out.println("product price :"+allcategory.get(k).allPrice.get(o).price());
                                                    System.out.println("Product Quantity :"+allcustomer.get(i).ProductQnt.get(j).getQuantity());
                                                    System.out.println();
                                                }
                                            } 
                                        }
                            
                                    }
                                }  
                                
                                }else if (allcustomer.get(i).deals.size()>0){
                                    System.out.println();
                                    custom.Dealproduct(i,allcategory,allcustomer);
                                }
                                
                                
                            }
                            if(option==8){
                                allcustomer.get(i).ProductQnt.clear();
                                allcustomer.get(i).ProductId.clear();
                                allcustomer.get(i).deals.clear();
                                System.out.println("Cart successfully emptied");

                            }



                            /////////////////////////////////////////////
                            if(option==9){

                                //i=index
                                Double TotalSum=0.0;
                                //all category indexes of cart products
                                ArrayList<Integer> Larray=new ArrayList<>();

                                //customer luch???
                                ArrayList<Integer> Jarray=new ArrayList<>();

                                ArrayList<Integer> arrayQunatity=new ArrayList<>();
                                ArrayList<Double> arrayPrice=new ArrayList<>();
                                ArrayList<Double> arrayDiscount=new ArrayList<>();
                                ArrayList<Double> arrayCoupon=new ArrayList<>();
                                ArrayList<Double> MaxDiscArray=new ArrayList<>();
                                ArrayList<Double> arrayDealprice=new ArrayList<>();
                                Double Dealprice=0.0;
                                Double Rawprice=0.0;
                                if (allcategory.get(i).allpdiscount.size()>0){
                                                                            // System.out.println("j");
                                        if (allcustomer.get(i).status().compareTo("ELITE")==0){
                                            for (int j=0;j<allcustomer.get(i).ProductId.size();j++){
                                        for (int k=0;k<allcategory.size();k++){
                                            // System.out.println("k");
                                            
                                            for (int l=0;l<allcategory.get(k).allPid.size();l++){
                                                // System.out.println("l");
                                                // System.out.println(allcategory.get(k).alldata.get(l).data());
                                                // System.out.println(allcategory.get(k).allPid.get(l).Pid()+" "+allcustomer.get(i).ProductId.get(j).Pid());
                                                if(allcategory.get(k).allPid.get(l).Pid().equals(allcustomer.get(i).ProductId.get(j).Pid())){
                                                    for (int o=0;o<allcategory.get(k).allpdiscount.size();o++){
                                                        arrayDiscount.add(allcategory.get(k).allpdiscount.get(o).Elite());
                                                        arrayPrice.add(allcategory.get(k).allPrice.get(o).price());
                                                        arrayQunatity.add(allcustomer.get(i).ProductQnt.get(j).getQuantity());
                                                    }
                                                } 
                                            }
                                
                                        } }
                                        }
                                        if (allcustomer.get(i).status().compareTo("PRIME")==0){
                                            for (int j=0;j<allcustomer.get(i).ProductId.size();j++){
                                            for (int k=0;k<allcategory.size();k++){
                                                // System.out.println("k");
                                                
                                                for (int l=0;l<allcategory.get(k).allPid.size();l++){
                                                    // System.out.println("l");
                                                    // System.out.println(allcategory.get(k).alldata.get(l).data());
                                                    // System.out.println(allcategory.get(k).allPid.get(l).Pid()+" "+allcustomer.get(i).ProductId.get(j).Pid());
                                                    if(allcategory.get(k).allPid.get(l).Pid().equals(allcustomer.get(i).ProductId.get(j).Pid())){
                                                        for (int o=0;o<allcategory.get(k).allpdiscount.size();o++){
                                                            arrayDiscount.add(allcategory.get(k).allpdiscount.get(o).Prime());
                                                            arrayPrice.add(allcategory.get(k).allPrice.get(o).price());
                                                        }
                                                    } 
                                                }
                                    
                                            } 
                                        }

                                        }
                                        else{
                                            for (int j=0;j<allcustomer.get(i).ProductId.size();j++){
                                            for (int k=0;k<allcategory.size();k++){
                                                // System.out.println("k");
                                                
                                                for (int l=0;l<allcategory.get(k).allPid.size();l++){
                                                    if(allcategory.get(k).allPid.get(l).Pid().equals(allcustomer.get(i).ProductId.get(j).Pid())){
                                                        for (int o=0;o<allcategory.get(k).allpdiscount.size();o++){
                                                            arrayDiscount.add(allcategory.get(k).allpdiscount.get(o).Normal());
                                                            arrayPrice.add(allcategory.get(k).allPrice.get(o).price());
                                                            arrayQunatity.add(allcustomer.get(i).ProductQnt.get(j).getQuantity());
                                                        }
                                                    } 
                                                }
                                    
                                            } 
                                        }

                                        }

                                    }



                                if (allcustomer.get(i).ProductId.size()>0){
                                    //customer data right for j
                                    for (int j=0;j<allcustomer.get(i).ProductId.size();j++){
                                        // System.out.println("j");
                                        for (int k=0;k<allcategory.size();k++){
                                            for (int l=0;l<allcategory.get(k).allPid.size();l++){

                                                if(allcategory.get(k).allPid.get(l).Pid().equals(allcustomer.get(i).ProductId.get(j).Pid())){
                                                    Larray.add(l);
                                                    Jarray.add(j);
                                                } 
                                            }
                                
                                        }
                                    }
                                    // for(int p=0;p<Jarray.size();p++){
                                    //     Rawprice+=((arrayPrice.get(p))*(arrayQunatity.get(p)));
                                    // }

                                    if (allcustomer.get(i).status().compareTo("ELITE")==0){
                                        //store added quantity in arrayquanty and Deal price in arrayDealprice by all J index
                                        if (allcustomer.get(i).deals.size()>0){
                                            for(int j:Jarray){
                                    
                                                
                                                arrayDealprice.add(allcustomer.get(i).deals.get(j).Dprice());
                                            }
                                    
                                        }
                                        else{
                                            for(int j:Jarray){
                                                arrayQunatity.add(allcustomer.get(i).ProductQnt.get(j).getQuantity());
                                                // System.out.println("quanty"+allcustomer.get(i).ProductQnt.get(j).getQuantity());
                                            }
                                    
                                        }

                                        //Check size of allcoupon is not empty

                                        // storing Raw price of individual in arrayPrice and Memberdiscount in arrayDiscount each product if have
                                        
                                        //Finding max Discount from MemberDiscount,specificDiscount and couponDiscount if have then store in MAxDisc array
                                        
                                        Double max=10.0;
                                            for (int j=0;j<Jarray.size();j++){
                                                
                                                Double D=arrayDiscount.get(j);
                                                    if(D>max){
                                                        max=D;
                                                    }
                                                
                                                MaxDiscArray.add(max);
                                            }
                                        
        
                                        Double Delivery=100.0;
                                        Double Discountedcart=0.0;

                                        //Getting Discounted Cart
                                        for (int j=0;j<Jarray.size();j++){
                                            Discountedcart+=arrayPrice.get(j)*arrayQunatity.get(j)*(1-(MaxDiscArray.get(j)/100));
                                        }
                                        //Getting Dealprice 
                                    
                                        if(arrayDealprice.size()>0){
                                        for(int j=0;j<Jarray.size();j++){
                                            Dealprice+=arrayDealprice.get(j);
                                        }
                                    }
                                    
                                        //getting Total price after all deduction(cost)
                                        TotalSum=Discountedcart+Delivery;
                                        Double amount=allcustomer.get(i).amount();
                                        if (TotalSum>amount){
                                            System.out.println("Account balance is running low");
                                            break;
                                        }
                                        //deduction of price in amountwallet
                                        else{
                                            Double a=amount-TotalSum;
                                            allcustomer.get(i).updateamount(a);
                                            System.out.println("Total cost = "+TotalSum);
                                            System.out.println("Order placed. It will be delivered in 2-3 days.");
                                            if (TotalSum>5000.0){
                                                System.out.println("You have won three coupons of 5% discount. Congratulations!!");
                                                allcustomer.get(i).coupons.add(5);
                                                allcustomer.get(i).coupons.add(5);
                                                allcustomer.get(i).coupons.add(5);
                                                
                                            }
                                            int s=allcustomer.get(i).ProductId.size();
                                            for (int j=0;j<allcustomer.get(i).ProductId.size();j++){
                                                // System.out.println("j");
                                                for (int k=0;k<allcategory.size();k++){
                                                    for (int l=0;l<allcategory.get(k).allPid.size();l++){

                                                        if(allcategory.get(k).allPid.get(l).Pid().equals(allcustomer.get(i).ProductId.get(j).Pid())){
                                                            int pquanty=arrayQunatity.get(j);
                                                            int cquantity=allcategory.get(k).allquantity.get(l).getQuantity();
                                                            int remainQ=cquantity-pquanty;


                                                                
                                                                allcategory.get(k).allquantity.get(l).addQuantity(remainQ);
                                                        } 
                                                    }
                                        
                                                }
                                            }

                                            for(int m=0;m<s;m++){
                                                allcustomer.get(i).ProductId.remove(0);
                                                allcustomer.get(i).ProductQnt.remove(0);
                                            }
                                        }
                                    }
                                    else if(allcustomer.get(i).status().compareTo("PRIME")==0){
                                        //if deal exists
                                        if(allcustomer.get(i).deals.size()>0){
                                        for(int j:Jarray){
                                            
                                            arrayDealprice.add(allcustomer.get(i).deals.get(j).Dprice());
                                        }
                                        
                                        }

                                        //if deal not exists
                                        else{
                                            for(int j:Jarray){
                                                arrayQunatity.add(allcustomer.get(i).ProductQnt.get(j).getQuantity());
                                                // System.out.println("quanty"+allcustomer.get(i).ProductQnt.get(j).getQuantity());
                                            }
                                    
                                        }

                                        //Check size of allcoupon is not empty

                                        // storing Raw price of individual in arrayPrice and Memberdiscount in arrayDiscount each product if have

                                        Double max=5.0;
                                        for (int j=0;j<Jarray.size();j++){
                                            
                                            Double D=arrayDiscount.get(j);
                                                if(D>max){
                                                    max=D;
                                                }
                                            
                                            MaxDiscArray.add(max);
                                        }


        
                                        Double Delivery=100.0;
                                        Double Discountedcart=0.0;


                                        //Getting Discounted Cart
                                        for (int j=0;j<Jarray.size();j++){
                                            Discountedcart+=arrayPrice.get(j)*arrayQunatity.get(j)*(1-(MaxDiscArray.get(j)/100));
                                        }
                                        //Getting Dealprice 

                                        if(arrayDealprice.size()>0){
                                        for(int j=0;j<Jarray.size();j++){
                                            Dealprice+=arrayDealprice.get(j);
                                        }
                                    }
                                    


                                        //getting Total price after all deduction(cost)
                                        TotalSum=Discountedcart+Delivery+(0.02)*(Rawprice+Dealprice);
                                        Double amount=allcustomer.get(i).amount();
                                        if (TotalSum>amount){
                                            System.out.println("Account balance is running low");
                                            break;
                                        }
                                        //deduction of price in amountwallet
                                        else{
                                            Double a=amount-TotalSum;
                                            allcustomer.get(i).updateamount(a);
                                            System.out.println("Total cost = "+TotalSum);
                                            System.out.println("Order placed. It will be delivered in 2-3 days.");
                                            if (TotalSum>5000.0){
                                                System.out.println("You have won two coupons of 5% discount. Congratulations!!");
                                                allcustomer.get(i).coupons.add(5);
                                                allcustomer.get(i).coupons.add(5);
                                            }
                                            int s=allcustomer.get(i).ProductId.size();
                                            for (int j=0;j<allcustomer.get(i).ProductId.size();j++){
                                                // System.out.println("j");
                                                for (int k=0;k<allcategory.size();k++){
                                                    for (int l=0;l<allcategory.get(k).allPid.size();l++){
                                    
                                                        if(allcategory.get(k).allPid.get(l).Pid().equals(allcustomer.get(i).ProductId.get(j).Pid())){
                                                            int pquanty=arrayQunatity.get(j);
                                                            int cquantity=allcategory.get(k).allquantity.get(l).getQuantity();
                                                            int remainQ=cquantity-pquanty;
                                    
                                    

                                                                allcategory.get(k).allquantity.get(l).addQuantity(remainQ);
                                                        } 
                                                    }
                                        
                                                }
                                            }
                                    
                                            for(int m=0;m<s;m++){
                                                allcustomer.get(i).ProductId.remove(0);
                                                allcustomer.get(i).ProductQnt.remove(0);
                                            }

                                            
                                        }
                                    }
                                    else{
                                    //if deal exists
                                    if (allcustomer.get(i).deals.size()>0){
                                        for(int j:Jarray){

                                            
                                            arrayDealprice.add(allcustomer.get(i).deals.get(j).Dprice());
                                        }

                                    }
                                    //if deal not exists
                                    else{
                                        for(int j:Jarray){
                                            arrayQunatity.add(allcustomer.get(i).ProductQnt.get(j).getQuantity());
                                            // System.out.println("quanty"+allcustomer.get(i).ProductQnt.get(j).getQuantity());
                                        }

                                    }

                                    for (int j=0;j<Jarray.size();j++){
                                        Double D=arrayDiscount.get(j);
                                        MaxDiscArray.add(D);
                                        // System.out.println("disc"+D);
                                    }
    
                                    Double Delivery=100.0;
                                    Double Discountedcart=0.0;
                                    //Getting Discounted Cart
                                    for (int j=0;j<Jarray.size();j++){
                                        
                                        Discountedcart+=arrayPrice.get(j)*arrayQunatity.get(j)*(1-(MaxDiscArray.get(j)/100));

                                    }

                                    if (allcustomer.get(i).deals.size()>0){
                                        for(int j=0;j<Jarray.size();j++){
                                            Dealprice+=arrayDealprice.get(j);
                                        }

                                    }else{
                                        
                                        TotalSum=Discountedcart+Delivery+(5/100)*(Rawprice+Dealprice);
                                        // System.out.println("total + Delivery"+TotalSum);
                                    }
                                    // System.out.println("1."+Rawprice);
                                    // System.out.println("2."+Dealprice);
                                    // System.out.println("3."+Delivery);
                                    // System.out.println("4."+Discountedcart);
                                    // System.out.println("5."+(0.05)*(Rawprice+Dealprice));

                                    TotalSum = Discountedcart + Delivery + (0.05)*(Rawprice+Dealprice);
                                    Double amount=allcustomer.get(i).amount();
                                    if (TotalSum>amount){
                                        System.out.println("Account balance is running low");
                                        break;
                                    }
                                    //deduction of price in amountwallet
                                    else{
                                        Double a=amount-TotalSum;
                                        allcustomer.get(i).updateamount(a);
                                        System.out.println("Total cost = "+TotalSum);
                                        System.out.println("Order placed. It will be delivered in 7-10 days.");
                                        int s=allcustomer.get(i).ProductId.size();

                                        for (int j=0;j<allcustomer.get(i).ProductId.size();j++){
                                            // System.out.println("j");
                                            for (int k=0;k<allcategory.size();k++){
                                                for (int l=0;l<allcategory.get(k).allPid.size();l++){
    
                                                    if(allcategory.get(k).allPid.get(l).Pid().equals(allcustomer.get(i).ProductId.get(j).Pid())){
                                                        int pquanty=arrayQunatity.get(j);
                                                        int cquantity=allcategory.get(k).allquantity.get(l).getQuantity();
                                                        int remainQ=cquantity-pquanty;
            
                                                        System.out.println("pq "+ pquanty);
                                                        System.out.println("cq "+cquantity);
                                                        System.out.println("rq "+remainQ);
        
                                                            System.out.println("in else");
                                                            allcategory.get(k).allquantity.get(l).addQuantity(remainQ);
                                                    } 
                                                }
                                    
                                            }
                                        }

                                        for(int m=0;m<s;m++){
                                            allcustomer.get(i).ProductId.remove(0);
                                            allcustomer.get(i).ProductQnt.remove(0);
                                        }
                                    }
                                    
                                }
                                }

                            }





                            //////////////////////////////////////////////////////

                    if(option==10){
                                System.out.println("Current status: "+allcustomer.get(i).status());
                                System.out.println("Choose new status: ");
                                String newstatus=input.nextLine();
                                if (newstatus.compareTo("ELITE")==0){
                                    if (allcustomer.get(i).amount()>=300){
                                        Double a=allcustomer.get(i).amount();
                                        allcustomer.get(i).updateamount(a-300);
                                        allcustomer.get(i).updatestatus("ELITE");
                                        System.out.println("Status updated to Elite");
                                    }
                                    else{
                                        System.out.println("Insufficient, Balance in your account");
                                    }
                                }
                                else if(newstatus.compareTo("PRIME")==0){
                                    if (allcustomer.get(i).amount()>=200){
                                        Double a=allcustomer.get(i).amount();
                                        allcustomer.get(i).updateamount(a-200);
                                        allcustomer.get(i).updatestatus("PRIME");
                                        System.out.println("Status updated to PRIME");
                                    }
                                    else{
                                        System.out.println("Insufficient, Balance in your account");
                                    }

                                }

            }
            if(option==11){
                System.out.println("Enter amount to add");
                Double amount=(double) Integer.parseInt(input.nextLine());
                Double a=allcustomer.get(i).amount();
                allcustomer.get(i).updateamount(amount+a);

            }
        }while(option!=12);

                    }
                }while(op4!=3);
                System.out.println("");
                

            }
        } while (op1 != 5);
        input.close();
    }

}

///////////////////////////////////////////* category */////////////////////////////////////////////////////////
class Category{
    int addID;
    String addnamecat;
    ArrayList<Price> allPrice;
    ArrayList<PID> allPid;
    ArrayList<Data> alldata;
    ArrayList<Quantity> allquantity;
    ArrayList<ProductDiscount> allpdiscount;
    ArrayList<ProductName> allProductname;

    
    Category(){

    }

    Category(int addID, String addnamecat) {
        this.addID = addID;
        this.addnamecat = addnamecat;
        this.allPid=new ArrayList<>();
        this.allPrice=new ArrayList<>();
        this.alldata=new ArrayList<>();
        this.allpdiscount=new ArrayList<>();
        this.allquantity=new ArrayList<>();
        this.allProductname=new ArrayList<>();

    }

    public int getID() {
        return this.addID;
    }

    public String getnamecat() {
        return this.addnamecat;
    }
    public int getsizeofPID(){
        return allPid.size();
    }
    public void AddData(ArrayList<Category> allcategory){
        Scanner input= new Scanner(System.in);
        System.out.println("Add a Product:-");
                            
        Double IDdouble=0.0;
        Double intprice=0.0;
        String data="";
        String s="";
        int intQuantity=0;
        String ProductName;
        

        String[] st=null;
            System.out.println("Enter Name of Product: ");
                ProductName=input.nextLine();
            System.out.println("Enter Price of product:");
                intprice=Double.parseDouble(input.nextLine());
            System.out.println("Enter Product id :");
                IDdouble=Double.parseDouble(input.nextLine());
            System.out.println("Enter Product Quantity:");
                intQuantity=Integer.parseInt(input.nextLine());
            System.out.println("Enter Product Desc:");
        do{
            String str=input.nextLine();
            st=str.split(" ");
                s=st[0];
                String[] St=null;
                data+=str+"\n";   

        }while(s.compareTo(".")!=0);

        Price price=new Price(intprice);
        allPrice.add(price);
        PID pid = new PID(IDdouble);
        allPid.add(pid);
        Data dt=new Data(data);
        alldata.add(dt);
        Quantity PQ=new Quantity(intQuantity);
        allquantity.add(PQ);
        ProductDiscount pd=new ProductDiscount(0.1,0.1,0.1);
        allpdiscount.add(pd);
        ProductName productname=new ProductName(ProductName);
        allProductname.add(productname);

    }
    public void AddData(int i,ArrayList<Category> allcategory){
        Scanner input= new Scanner(System.in);
        System.out.println("Add a Product:-");
                            
        Double IDdouble=0.0;
        Double intprice=0.0;
        String data="";
        String s="";
        int intQuantity=0;
        String ProductName;
        

        String[] st=null;
            System.out.println("Enter Name of Product: ");
                ProductName=input.nextLine();
            System.out.println("Enter Price of product:");
                intprice=Double.parseDouble(input.nextLine());
            System.out.println("Enter Product id :");
                IDdouble=Double.parseDouble(input.nextLine());
            System.out.println("Enter Product Quantity:");
                intQuantity=Integer.parseInt(input.nextLine());
            System.out.println("Enter Product Desc:");
        do{
            String str=input.nextLine();
            st=str.split(" ");
                s=st[0];
                String[] St=null;
                data+=str+"\n";   

        }while(s.compareTo(".")!=0);

        Price price=new Price(intprice);
        allcategory.get(i).allPrice.add(price);
        PID pid = new PID(IDdouble);
        allcategory.get(i).allPid.add(pid);
        Data dt=new Data(data);
        allcategory.get(i).alldata.add(dt);
        Quantity PQ=new Quantity(intQuantity);
        allcategory.get(i).allquantity.add(PQ);
        ProductDiscount pd=new ProductDiscount(0.1, 0.1, 0.1);
        allcategory.get(i).allpdiscount.add(pd);
        ProductName productname=new ProductName(ProductName);
        allcategory.get(i).allProductname.add(productname);
        
    }
    public void  Getcatalog(ArrayList<Category> allcategory){
        System.out.println("----------Catalog Looks Like-----------");
        System.out.println("\n");
        for (int i=0;i<allcategory.size();i++){

            String ans="";
            System.out.println("Category name: "+allcategory.get(i).getnamecat());
            for (int j=0;j<allcategory.get(i).getsizeofPID();j++){

                ans=allcategory.get(i).alldata.get(j).data();
                System.out.println("Product Price "+allcategory.get(i).allPrice.get(j).price());
                System.out.println("Product ID "+allcategory.get(i).allPid.get(j).Pid());
                System.out.println("Product Quantity "+allcategory.get(i).allquantity.get(j).getQuantity());
                System.out.println(ans);
            }
            System.out.println("-------------------------------------------------");

        }


    }
    public void giveaway(ArrayList<Giveaway> allgiveaway,ArrayList<Category> allcategory){
        Scanner input=new Scanner(System.in);
        System.out.println("Dear Admin give the Product IDs you want to combine and giveaway a deal for");
        System.out.println("\n");
        System.out.println("Enter the first Product ID :");
        Double Enter1stPID=Double.parseDouble(input.nextLine());
        System.out.println("Enter the second Product ID:");
        Double Enter2ndPID=Double.parseDouble(input.nextLine());
        System.out.println("Enter the combined price(Should be less than their combined price):");

        Double Eprice=Double.parseDouble(input.nextLine());
        Double Pprice=Double.parseDouble(input.nextLine());
        Double Nprice=Double.parseDouble(input.nextLine());
        Double fprice=0.0;
        Double sprice=0.0;
        double sum=0;
        for (int i=0;i<allcategory.size();i++){
            for (int f=0;f<allcategory.get(i).getsizeofPID();f++){
                if (allcategory.get(i).allPid.get(f).Pid().equals(Enter1stPID)){
                    fprice=allcategory.get(i).allPrice.get(f).price();
                    break;
                }

            }
            for (int s=0;s<allcategory.get(i).getsizeofPID();s++){
                if (allcategory.get(i).allPid.get(s).Pid().equals(Enter2ndPID)){
                sprice=allcategory.get(i).allPrice.get(s).price();
                break;
                }
            }
        }
            sum=fprice+sprice;
            if (sum>Eprice && sum>Pprice && sum>Nprice){
                Giveaway giveaway=new Giveaway(Enter1stPID,Enter2ndPID,Eprice,Pprice,Nprice);
                allgiveaway.add(giveaway);
            }
            else{
                System.out.println("combined Price should be less than their sum of price");
                System.out.println("\n");
            }
            System.out.println("\n");
    }

    public void setDiscount(ArrayList<Category> allcategory){
        Scanner input=new Scanner(System.in);
        System.out.println("Dear admin give the Product ID you want to add discount for");
        System.out.println();
        System.out.println("Enter the Product ID :");
        Double ID=Double.parseDouble(input.nextLine());
        int ind=0;
        int fnd=0;
        for (int i=0;i<allcategory.size();i++){
            for (int f=0;f<allcategory.get(i).getsizeofPID();f++){
                if (ID.equals(allcategory.get(i).allPid.get(f).Pid())){
                    ind=i;
                    fnd=f;
                    break;
                }
            }
        }
        System.out.println("Enter discount for Elite, Prime and Normal customers respectively (in % terms)");
        Double e=Double.parseDouble(input.nextLine());
        Double p=Double.parseDouble(input.nextLine());
        Double n=Double.parseDouble(input.nextLine());
        ProductDiscount pd=new ProductDiscount(e, p, n);
        allcategory.get(ind).allpdiscount.set(fnd, pd);
    }

}
class ProductName{
    String productname;
    ProductName(){

    }
    ProductName(String name){
        this.productname=name;
    }
    public String Productname(){
        return this.productname;
    }
    public void Productname(String name){
        this.productname=name;
    }

}

///////////////////////////////////ProductDiscount//////////////////////////////////
class ProductDiscount{
    Double Elite;
    Double Prime;
    Double Normal;
    ProductDiscount(){

    }
    ProductDiscount(Double e,Double p,Double n){
        this.Elite=e;
        this.Prime=p;
        this.Normal=n;
    }
    public Double Elite(){
        return this.Elite;

    }
    public Double Prime(){
        return this.Prime;
    }
    public Double Normal(){
        return this.Normal;
    }
}
////////////////////////////////////////GIVEAWAY///////////////////////////////////////////
class Giveaway extends Category{
    private Double ProductsID1;
    private Double ProductsID2;
    private Double elitePrice;
    private Double primePrice;
    private Double normalPrice;
    private int giveQuantity;

    Giveaway(){

    }
    Giveaway(Double ProductID1,Double ProductID2,Double elitePrice,Double primePrice,Double normalPrice){
        this.ProductsID1=ProductID1;
        this.ProductsID2=ProductID2;
        this.elitePrice=elitePrice;
        this.primePrice=primePrice;
        this.normalPrice=normalPrice;
        this.giveQuantity=1;
    }
    public Double ProductID1(){
        return this.ProductsID1;
    }
    public Double ProductID2(){
        return this.ProductsID2;
    }
    public Double elitePrice(){
        return this.elitePrice;
    }
    public Double primePrice(){
        return this.primePrice;
    }
    public Double normalPrice(){
        return this.normalPrice;
    }
    public int getgiveQuant(){
        return this.giveQuantity;
    }
    public void increQuant(int a){
        this.giveQuantity=a;
    }

    public void Addgiveaway(ArrayList<Giveaway> allgiveaway,ArrayList<Category> allcategory){
        giveaway(allgiveaway,allcategory);

    }
    public void Getgiveaway(ArrayList<Giveaway> allgiveaway){
        System.out.println("-------Available Deals---------"+"\n");
        int count=1;
        for (int i=0;i<allgiveaway.size();i++){
            System.out.println(count+"    Buy these Product IDs"+allgiveaway.get(i).ProductID1()+" and "+allgiveaway.get(i).ProductID2());
            System.out.println("     Deal Price is : Rs "+allgiveaway.get(i).elitePrice()+"/-"+allgiveaway.get(i).primePrice()+"/-"+allgiveaway.get(i).normalPrice()+"/-");
            count++;
        }

    }

}
///////////////////////////////////Price/////////////////////////////////////
class Price{
    private Double price;
    Price(){

    }
    Price(Double intprice){
        this.price=intprice;
    }
    public void price(Double p){
        this.price=p;
    }
    public Double price(){
        return this.price;
    }
}
////////////////////////////////////PID///////////////////////////////////////
class PID{
    private Double Pid;
    PID(){

    }
    PID(Double pid){
        this.Pid=pid;
    }
    public void Pid(Double pid){
        this.Pid=pid;
    }
    public Double Pid(){
        return this.Pid;
    }
}
///////////////////////////////////Data//////////////////////////////////////
class Data{
    private String data;
    Data(){

    }
    Data(String s){
        this.data=s;
    }
    public void data(String d){
        this.data=d;
    }
    public String data(){
        return this.data;
    }

}

class Customer extends Category{
    String Name;
    String Password;
    Double amount;
    String status;
    ArrayList<Integer> coupons;
    ArrayList<PID> ProductId;
    ArrayList<Quantity> ProductQnt;
    ArrayList<Deal> deals;
    
    Customer(){
        // this.ProductId=new ArrayList<>();
        // this.ProductQnt=new ArrayList<>();
    }
    Customer(String name,String password ){
        this.Name=name;
        this.Password=password;
        this.amount=1000.0;
        this.status="Normal";
        this.ProductId=new ArrayList<>();
        this.ProductQnt=new ArrayList<>();
        this.deals=new ArrayList<>();
        this.coupons=new ArrayList<>();
        // PID pid=new PID(0.0);
        // Quantity qnt=new Quantity(0);
        // ProductId.add(pid);
        // ProductQnt.add(qnt);
        // Deal deal=new Deal("",(double) 0);
        // deals.add(deal);
        // Coupon coupon=new Coupon(0.1);
        // allcoupon.add(coupon);
        }

    public String Name(){
        return this.Name;
    }
    public String Password(){
        return this.Password;
    }
    public Double amount(){
        return this.amount;
    }
    public String status(){
        return this.status;
    }
    public void updatestatus(String s){
        this.status=s;
    }
    public void updateamount(double d){
        this.amount=d;
    }
    public void addproducttocart(int i,ArrayList<Customer> allcustomer,ArrayList<Category> allcategory){
        Scanner input=new Scanner(System.in);
        System.out.println("Enter Product ID and quantity");
        Double id=Double.parseDouble(input.nextLine());
        int quantity=Integer.parseInt(input.nextLine());
            PID pi=new PID(id);
            Quantity qnty=new Quantity(quantity);

            allcustomer.get(i).ProductId.add(pi);
            allcustomer.get(i).ProductQnt.add(qnty);
            

    }
    public void Browsedeals(int loc,ArrayList<Giveaway> allgiveaway,ArrayList<Customer> allcustomer){
        System.out.println("-------Available Deals---------"+"\n");
        int count=1;
        for (int i=0;i<allgiveaway.size();i++){
            System.out.println(count+"    Buy these Product IDs"+allgiveaway.get(i).ProductID1()+" and "+allgiveaway.get(i).ProductID2());
            if (allcustomer.get(i).status().compareTo("ELITE")==0){
                System.out.println("     Deal Price is : Rs "+allgiveaway.get(i).elitePrice()+"/-");
            }else if (allcustomer.get(i).status().compareTo("PIME")==0){
                System.out.println("     Deal Price is : Rs "+allgiveaway.get(i).primePrice()+"/-");
            }
            else{
                System.out.println("     Deal Price is : Rs "+allgiveaway.get(i).normalPrice()+"/-");
            }
            count++;
        }
    }
    public void Adddeal(Double first,Double second,int loc,ArrayList<Customer> allcustomer,ArrayList<Giveaway> allgiveaway){
        allcustomer.get(loc).deals.get(loc).pId(first+" "+second);
        Double a=0.0;
        for (int i=0;i<allgiveaway.size();i++){
            if (allcustomer.get(i).status().compareTo("ELITE")==0){
            a=allgiveaway.get(i).elitePrice();
            allcustomer.get(loc).deals.get(loc).Dprice(a);
            }else if (allcustomer.get(i).status().compareTo("PIME")==0){
                allcustomer.get(loc).deals.get(loc).Dprice(a);
            }
            else{
                allcustomer.get(loc).deals.get(loc).Dprice(a);            }
        }

    }
    public void Dealproduct(int loc ,ArrayList<Category> allcategory,ArrayList<Customer> allcustomer ){
        Double first=0.0;
        Double second=0.0;
        if (deals.size()==0){
            System.out.println("no deal added");
        }else{
         for (int i=0;i<deals.size();i++){
            String[] st=null;
            String str=deals.get(i).pId();
            st=str.split(" ");
            first=Double.parseDouble(st[0]);
            second=Double.parseDouble(st[1]);
            System.out.println("Product IDs "+first+" "+second);
            System.out.println("Deal Price is: "+deals.get(i).Dprice());
            }   
        }
    }

}
class Deal{
    String pId;
    Double Dprice;
    Deal(){

    }
    Deal(String pid,Double price){
        this.pId=pid;
        this.Dprice=price;
    }
    public String  pId(){
        return this.pId;
    }
    public void pId(String p){
        this.pId=p;
    }
    public Double  Dprice(){
        return this.Dprice;
    }
    public void Dprice(Double p){
        this.Dprice=p;
    }
}
///////////////////////////////////ProductQuantity//////////////////////////////////
class Quantity implements Qnty{
    int Quantity;
    Quantity(){

    }
    Quantity(int i){
    this.Quantity=i;
    }
    public void addQuantity(int i){
        this.Quantity=i;
    }
    @Override
    public int getQuantity(){
        return this.Quantity;
    }

}

interface Qnty{

    public int getQuantity();
}

class Coupon{
    Double coupon;
    Coupon(){};
    Coupon(Double cpn){
        this.coupon=cpn;
    }

    public Double getcoupon(){
        return this.coupon;
    }
    public void setcoupon(Double c){
        this.coupon=c;
    }
}

