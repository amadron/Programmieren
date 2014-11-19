package object;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL11.*;

public class Object3D {
	public String Name;
	public Vertex3DList Model;
	public boolean visible;
	
	public Object3D(String name, Vertex3DList model){
		Name = name;
		Model = model;
	}
	
	public void display(){
		if(Model.vertexList.size() > 0 && Model != null && visible == false){
			GL11.glBegin(GL11.GL_TRIANGLE_FAN);
			for(int i = 0; i < Model.vertexList.size(); i++){
				float x = Model.vertexList.get(i).x;
				float y = Model.vertexList.get(i).y;
				float z = Model.vertexList.get(i).z;
				GL11.glVertex3f(x, y, z);
			}
			GL11.glEnd();
		}
	}
}
