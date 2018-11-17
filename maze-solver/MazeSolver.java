import data_structures.*;

public class MazeSolver {
	private MazeGrid maze;
	private Queue list;
	private Stack path;
	private GridCell terminalCell;
	private int demension;
	
//  The constructor. Takes a single argument, the number of rows and columns in the grid. Suggested values are 25 .. 50.
	public MazeSolver(int size) {
		demension = size;
		maze = new MazeGrid(this, size);
		list = new Queue();
		path = new Stack();
	}
	
//  This method runs the breadth first traversal, and marks each reachable cell in the grid with its distance from the origin.
	public void mark(){
		list.enqueue(maze.getCell(0,0));
		terminalCell = maze.getCell(0,0);
		while(!list.isEmpty()) {
			GridCell current = (GridCell) list.dequeue();
			if(!current.wasVisited()){
				int x = current.getX();
				int y = current.getY();
				GridCell north = maze.getCell(x,y-1);
				GridCell south = maze.getCell(x,y+1);
				GridCell east = maze.getCell(x+1,y);
				GridCell west = maze.getCell(x-1,y);
			    if(maze.isValidMove(north))
			    	list.enqueue(north);
			    if(maze.isValidMove(south))
			    	list.enqueue(south);
			    if(maze.isValidMove(east))
			    	list.enqueue(east);
			    if(maze.isValidMove(west))
			    	list.enqueue(west);
			    if(current == maze.getCell(0, 0))
			    	current.setDistance(0);
			    else{
			    	if (maze.isValidMove(north) && north.getDistance() != -1)
			    		current.setDistance(north.getDistance()+1);
			    	if (maze.isValidMove(south) && south.getDistance() != -1)
			    		current.setDistance(south.getDistance()+1);
			    	if (maze.isValidMove(east) && east.getDistance() != -1)
			    		current.setDistance(east.getDistance()+1);
			    	if (maze.isValidMove(west) && west.getDistance() != -1)
			    		current.setDistance(west.getDistance()+1);
			    }
			    maze.markDistance(current); 
			}
		}
	}

//  Does part two, indicates in the GUI the shortest path found.
	public boolean move(){
		GridCell current = maze.getCell(demension-1, demension-1);
		int distance = current.getDistance();
		if(distance == -1) return false;  // unreachable, puzzle has no solution
		while(current.getDistance() != 0) {
			distance = current.getDistance();
		    int x = current.getX();
		    int y = current.getY();
		    GridCell north = maze.getCell(x,y-1);
			GridCell south = maze.getCell(x,y+1);
			GridCell east = maze.getCell(x+1,y);
			GridCell west = maze.getCell(x-1,y);
		    if(maze.isValidMove(north) && north.getDistance()+1 == distance){
		    	path.push(current);
		    	current = north;
		    }
		    else if(maze.isValidMove(south) && south.getDistance()+1 == distance){
		    	path.push(current);
		    	current = south;
		    }
		    else if(maze.isValidMove(east) && east.getDistance()+1 == distance){
		    	path.push(current);
		    	current = east;	
		    }
		    else if (maze.isValidMove(west) && west.getDistance()+1 == distance){
		    	path.push(current);
		    	current = west;
		    }
		    
		}
		while(!path.isEmpty()) {
		    current = (GridCell)path.pop();
		    maze.markMove(current);
		}
		return true;
	}
	
//  Reinitializes the puzzle. Clears the stack and queue (calls makeEmpty() ).
	public void reset(){
		list.makeEmpty();
		path.makeEmpty();
	}
	
	public static void main(String []array) {
		new MazeSolver(35);
	}
}
