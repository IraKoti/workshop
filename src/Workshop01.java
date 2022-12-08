import java.io.Console;
import java.util.ArrayList;

/**
 * Workshop01
 */
public class Workshop01 
{

    public static void main(String[] args) 
    {
        Console cons = System.console();
        String[] checkInput, itemAdd;
        ArrayList<String> itemList = new ArrayList<String>();
        String userInput, command="";
        Integer itemDel;
        boolean exit = false;
        System.out.println("Welcome to your shopping cart");
        while (!exit) 
        {
            userInput = cons.readLine("> ");
            checkInput = userInput.trim().split(" ",2);
            command = checkInput[0].trim().toLowerCase();
            switch (command) 
            {
                case "list":
                    
                    if(itemList.size()==0)
                    {
                        System.out.println("Your cart is empty");
                    }
                    else
                    {
                        Integer i = 0;
                        for (String item : itemList) 
                        {
                            System.out.printf("%d. %s\n",i+1,item);
                            i++;
                        }
                    }
                    break;

                case "add":
                    if(checkInput.length <2)
                    {
                        System.out.println("Enter items need to be add");
                    }
                    else
                    {
                        itemAdd = checkInput[1].split(", ");
                        for(Integer i=0; i<itemAdd.length; i++)
                        {
                            if(itemList.size()>0)
                            {
                                boolean sameItem = false;
                                for (String item : itemList) 
                                {
                                    if(item.equalsIgnoreCase(itemAdd[i]))
                                    {
                                        sameItem = true;
                                    }
                                }
                                if(!sameItem)
                                {
                                    itemList.add(itemAdd[i]);
                                    System.out.println(itemAdd[i]+ " have been added to cart");
                                }
                                else
                                {
                                    System.out.println(itemAdd[i] + " is exist, will not add into the cart");
                                }
                            }
                            else
                            {
                                itemList.add(itemAdd[i]);
                                System.out.println(itemAdd[i]+ " have been added to cart");
                            }
                            
                        }
                    }
                    break;

                case "delete":
                if(checkInput.length <2)
                {
                    System.out.println("Enter delete item index number that need to be delete");
                }
                else
                {
                    itemDel = Integer.parseInt(checkInput[1]);
                    if(itemList.size()==0)
                    {
                        System.out.println("Cart is empty.");
                    }
                    else 
                    {
                        if(itemDel>itemList.size())
                        {
                            System.out.println("Enter the correct index");
                        }
                        else
                        {
                            System.out.printf("%s removed from cart\n",itemList.get(itemDel-1));
                            itemList.remove(itemDel-1);
                        }
                    }
                }
                    break;
                
                case "exit":
                    exit = true;
                    break;
            
                default:
                    System.out.println("Only accept: add, delete, list or exit");
                    break;
            }
        }        
    }
}