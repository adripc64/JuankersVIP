package fgeExamples;

import fge.App;
import fge.Color;
import fge.Font;
import fge.Render;
import fge.Service;

public class RenderExamples extends Service {
	
	private Font font;
	private Color fontColor;

	public static void main(String[] args) {
		App.run(new RenderExamples(), 640, 480);
	}

	@Override
	protected void onStart() {
		font = new Font("data/COMIC.TTF", 18);
		fontColor = new Color(255,255,0);
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void onMove() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void onDraw() {
		int x = 10;
		int y = 10;
		Render.DrawText(font, x, y, "Puntos:", fontColor);
		y += font.getFontSize();
		for (int px = x; px <= x +100; px += 5) {
			for (int py = y+10; py <= y+40; py += 5) {
				Render.DrawPoint(px, py, new Color(255,0,0));
			}
		}
		y += 50;
		Render.DrawText(font, x, y, "Líneas:", fontColor);
		y += font.getFontSize();
		Render.DrawLine(x, y+10, x+100, y+10, new Color(255,0,0));
		Render.DrawLine(x, y+10, x+100, y+20, new Color(0,255,0));
		Render.DrawLine(x, y+30, x+100, y+20, new Color(0,255,255));
		Render.DrawLine(x, y+30, x+100, y+30, new Color(255,0,255));
		y += 50;
		Render.DrawText(font, x, y, "Rectángulos:", fontColor);
		y += font.getFontSize();
		Render.DrawRectangle(x, y+10, 100, 25, 0, new Color(255,0,0));
		Render.DrawFilledRectangle(x+110, y+10, 100, 25, 0, new Color(255,0,0));
		Render.DrawRectangle(x+220, y+10, 100, 25, 20, new Color(255,0,0));
		Render.DrawFilledRectangle(x+330, y+10, 100, 25, 45, new Color(255,0,0));
		y += 50;
		Render.DrawText(font, x, y, "Círculos:", fontColor);
		y += font.getFontSize();
		Render.DrawCircle(x+30, y+30, 25, new Color(255,0,0));
		Render.DrawFilledCircle(x+90, y+30, 25, new Color(255,0,0));
	}

}
