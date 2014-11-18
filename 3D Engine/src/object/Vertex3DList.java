package object;

import java.util.List;

public class Vertex3DList {
	List<Vertex3D> vertexList;
	
	public Vertex3DList(List<Vertex3D> list){
		vertexList = list;
	}
	
	public void setVertexList(List<Vertex3D> list){
		vertexList = list;
	}
	
	public Vertex3D getCenter(){
		Vertex3D center = new Vertex3D();
		center.x = 0;
		center.y = 0;
		center.z = 0;
		float xMax, xMin;
		float yMax, yMin;
		float zMax, zMin;
		if(vertexList.size() > 0){
			xMax = vertexList.get(0).x;
			xMin = vertexList.get(0).x;
			yMax = vertexList.get(0).y;
			yMin = vertexList.get(0).y;
			zMax = vertexList.get(0).z;
			zMin = vertexList.get(0).z;
			for (int i= 0; i < vertexList.size(); i++){
				if(xMax < vertexList.get(i).x)
					xMax = vertexList.get(i).x;
				if(xMin > vertexList.get(i).x)
					xMin = vertexList.get(i).x;
				if(yMax < vertexList.get(i).y)
					yMax = vertexList.get(i).y;
				if(yMin > vertexList.get(i).y)
					yMin = vertexList.get(i).y;
				if(zMax < vertexList.get(i).z)
					zMin = vertexList.get(i).z;
				if(zMin > vertexList.get(i).z)
					zMin = vertexList.get(i).z;
			}
			center.x = (xMax + xMin)/2;
			center.y = (yMax + yMin)/2;
			center.z = (zMax + zMin)/2;
		}
	
		
		return center;
	}
}
