import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.*;
import org.lwjgl.glfw.GLFWVidMode;

public class Main {
	
	long window;
	int wheight = 480;
	int wwidth = 640;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main game = new Main();
		game.startGame();
	}
	
	public void startGame() {
		init();
		gameLoop();
		dispose();
	}
	
	public void init() {
	    if(!glfwInit()){
	     throw new IllegalStateException("GLFW initialization failed!");
	    }
	    
	    glfwWindowHint(GLFW_RESIZABLE, GL_TRUE);
	    
	    window = glfwCreateWindow(wwidth, wheight, "Endless Driver", NULL, NULL);

	    
	    if(window == NULL){
		     throw new IllegalStateException("Could not create our Window!");
	    }
	    
	    GLFWVidMode vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor());
	    
	    glfwSetWindowPos(window, (vidmode.width() - wwidth) / 2, (vidmode.height() - wheight) / 2);
	    
	    glfwMakeContextCurrent(window);
	    
	    glfwShowWindow(window);
	}
	
	public void gameLoop() {
	    boolean running = true;
	    double currentTime;
	    float delta = 0f;
	    float delta2 = 0f;
	    int fps = 0;
	    int ups = 0;
	    double previousTime = glfwGetTime();
	    
		while(running){
			
			currentTime = glfwGetTime();
			delta += (float) (currentTime - previousTime) * 60;
			delta2 += (float) (currentTime - previousTime);
			previousTime = currentTime;
			
			while(delta >= 1f) {

				input();
				
				if(glfwWindowShouldClose(window)){
					running = false;
				}
				
				update();
				
				ups++;
				delta -= 1f;
			}

			render();
			
			fps++;
			
			if(delta2 >= 1f) {
				System.out.println("UPS:" + ups + " FPS:" + fps);
		        fps = 0;
		        ups = 0;
		        delta2 -= 1;
			}
			
		}
	}
	
	public void input() {
		glfwPollEvents();
	}
	
	public void update() {
		
	}
	
	public void render() {
		glClearColor(0.2f, 0.3f, 0.3f, 1.0f);
        glClear(GL_COLOR_BUFFER_BIT);

        // draw our first triangle
        //glUseProgram(shaderProgram);
        //glBindVertexArray(VAO); // seeing as we only have a single VAO there's no need to bind it every time, but we'll do so to keep things a bit more organized
        //glDrawArrays(GL_TRIANGLES, 0, 6);
        //glDrawElements(GL_TRIANGLES, 6, GL_UNSIGNED_INT, 0);
		glfwSwapBuffers(window);
	}
	
	public void dispose() {
		//glfwFreeCallbacks(window);
		glfwDestroyWindow(window);
		glfwTerminate();
	}

}
