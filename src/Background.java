
public class Background {
	private int mapx;
	private int mapy;
	private float cameraxpos;
	private float cameraypos;
	private Texture texture;
	
	public Background(String path, float camposx, float camposy) {
		texture = new Texture(path);
		cameraxpos = camposx;
		cameraypos = camposy;
		mapx = texture.getWidth();
		mapy = texture.getHeight();
	}
	
	public Background(String path) {
		texture = new Texture(path);
		mapx = texture.getWidth();
		mapy = texture.getHeight();
		cameraxpos = mapx/2;
		cameraypos = mapy/2;
	}
}
