import java.util.ArrayList;


public class main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Page> g = new ArrayList<Page>();
		Page p1 = new Page("1",0.2,0.2);
		Page p2 = new Page("2",0.2,0.2);
		Page p3 = new Page("3",0.2,0.2);
		Page p4 = new Page("4",0.2,0.2);
		Page p5 = new Page("5",0.2,0.2);
		
		p1.getIncomingNeighbors().add(p4);
		p1.getOutgoingNeighbors().add(p2);
		p1.getOutgoingNeighbors().add(p3);
		p1.getOutgoingNeighbors().add(p5);
		
		p2.getIncomingNeighbors().add(p1);
		p2.getOutgoingNeighbors().add(p4);
		
		p3.getIncomingNeighbors().add(p1);
		p3.getOutgoingNeighbors().add(p5);
		
		p4.getIncomingNeighbors().add(p2);
		p4.getOutgoingNeighbors().add(p1);
		p4.getOutgoingNeighbors().add(p5);
		
		p5.getIncomingNeighbors().add(p1);
		p5.getIncomingNeighbors().add(p3);
		p5.getIncomingNeighbors().add(p4);
		
		g.add(p1);
		g.add(p2);
		g.add(p3);
		g.add(p4);
		g.add(p5);
		
		HubsAndAuthorities(g);
		
	}
	
	public static void HubsAndAuthorities(ArrayList<Page> G)
	{
		int step = 0;
		int k = 1;
		
		// norm is use for normalization, or the number of step and node cannot be large
		double norm = 0;
		for (step = 0; step <= k; step++)
		{
			norm = 0;
			for(int n = 0; n < G.size(); n++)
			{
				Page p = G.get(n);
				p.setAuth(0);
				for(int m = 0; m < p.getIncomingNeighbors().size(); m++)
				{
					Page q = p.getIncomingNeighbors().get(m);
					p.setAuth(p.getAuth()+q.getHub());
				}
				norm = norm + Math.sqrt(p.getAuth());
			}
			norm = Math.sqrt(norm);
			
			for(int n = 0; n < G.size(); n++)
			{
				Page p = G.get(n);
				p.setAuth(p.getAuth() / norm);
			}
			
			norm = 0;
			
			for(int n = 0; n < G.size(); n++)
			{
				Page p = G.get(n);
				p.setHub(0);
				for(int m = 0; m < p.getOutgoingNeighbors().size(); m++)
				{
					Page r = p.getOutgoingNeighbors().get(m);
					p.setHub(p.getHub()+r.getAuth());
				}
				norm = norm + Math.sqrt(p.getHub());
			}
			norm = Math.sqrt(norm);
			
			for(int n = 0; n < G.size(); n++)
			{
				Page p = G.get(n);
				p.setHub(p.getHub() / norm);
			}
			
			System.out.println("Step:"+(step+1));
			for(int i = 0; i < G.size(); i++)
			{
				Page tmp = G.get(i);
				System.out.println("Page:"+tmp.getName()+" Auth:"+tmp.getAuth()+" Hub:"+tmp.getHub());
			}
		}
	}

}
