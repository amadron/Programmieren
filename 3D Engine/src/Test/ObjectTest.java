package Test;
import java.util.LinkedList;
import object.Vertex3D;
import object.Vertex3DList;

public class ObjectTest {

	public static void main(String[] args) {
		LinkedList<Vertex3D> list = new LinkedList<Vertex3D>();
		list.add(new Vertex3D(0, 0, 0));
		list.add(new Vertex3D(3, 0, 0));
		list.add(new Vertex3D(3, 3, 0));
		list.add(new Vertex3D(0, 3, 0));
		list.add(new Vertex3D(0, 3, 3));
		list.add(new Vertex3D(3, 3, 3));
		list.add(new Vertex3D(3, 0, 3));
		list.add(new Vertex3D(0, 0, 3));
		Vertex3DList vList = new Vertex3DList(list);
		
		Vertex3D center = vList.getCenter();
		System.out.println("center x: " + center.x);
		System.out.println("center y: " + center.y);
		System.out.println("center z: " + center.z);
	}	

}
