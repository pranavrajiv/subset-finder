package subsetFinder;
import java.util.ArrayList;
import java.util.List;

public class subfin {
	public static int counter=0;
	
	public static void helper(int a[],List<List<Integer>> listNum,int size)
	{
		if(size==0)
			return;
		List<List<Integer>> NewlistNum = new ArrayList<>();
		for(int i =0;i<listNum.size();i++)
		{
			System.out.print("{ ");
			for(int j =0;j<listNum.get(i).size()-1;j++)
				System.out.print(listNum.get(i).get(j)+", ");	
			System.out.println(listNum.get(i).get(listNum.get(i).size()-1)+" }");
			counter = counter+1;
		}
			
		for(int i =0;i<listNum.size();i++)
		{	
			int flag=-1;
			for(int k=0;k<a.length;k++)
			{
				if(listNum.get(i).get(listNum.get(i).size()-1)==a[k])
				{
					flag =k;
					break;
				}
			}

			for(int j =flag+1;j<a.length;j++)
			{
				List<Integer> ln=  new ArrayList<>();
				NewlistNum.add(ln);
				for(int u=0;u<listNum.get(i).size();u++)
					ln.add(listNum.get(i).get(u));		
				ln.add(a[j]);
			}
		}
		helper(a,NewlistNum,--size);			
	}
	
	public static void  main(String[] args)
	{
		System.out.println("{ }");
		
		//the array that you need to find the subset of
		int a[] ={1,2,3,4,5,6,7,8,9,10};
		List<List<Integer>> listNum = new ArrayList<>();
		for(int i =0;i<a.length;i++)
		{
			List<Integer> ln=  new ArrayList<>();
			listNum.add(ln);
			ln.add(a[i]);	
		}
		helper(a,listNum,a.length);		
		System.out.println(" Number of Subsets = "+ ++counter);
	}	
}
