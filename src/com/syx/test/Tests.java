package com.syx.test;

import org.junit.Test;

public class Tests {

	@Test
	public void XYZToBLH(){
		double SourceX =  -1531634.859;
		double SourceY = 6189817.498;
		double SourceZ =  146531.631;
		
		double destinationB = 0,destinationL = 0,destinationH = 0;
		double da = 6378137.0;
		double df = 298.257223563;

		double e2;
		double A,F;
		double N;
		F=1.0/df;
		A=da;
		e2 = 2 * F - F * F;
		double dl=Math.atan2(SourceY, SourceX);
		destinationL=dl;

		double b1,b2,h1,h2;
		h1=Math.sqrt(Math.pow(SourceX,2)+Math.pow(SourceY,2)+Math.pow(SourceZ,2))-A;
		b1=Math.atan2((SourceZ/Math.sqrt(SourceX*SourceX+SourceY*SourceY)),(1.-e2*A/(A+h1)));
		
		if (Math.abs(SourceZ) < 1E-4)
		{
			destinationB = 0;
			destinationL = 0;
			destinationH = 0;
			return;
		}

		do
		{
			N=A/(Math.sqrt(1.-e2*Math.sin(b1)*Math.sin(b1)));
			h2=h1;b2=b1;
			h1=SourceZ/Math.sin(b1)-N*(1-e2);
			b1=Math.atan2((SourceZ/Math.sqrt(SourceX*SourceX+SourceY*SourceY)),(1.-e2*N/(N+h1)));

		}while(Math.abs(b2-b1)>Math.pow(10.0,-11)||Math.abs(h2-h1)>Math.pow(10.0,-5));

		destinationB=b1;
		N=A/(Math.sqrt(1.-e2*Math.sin(b1)*Math.sin(b1)));
		destinationH=SourceZ/Math.sin(b1)-N*(1-e2);

		destinationB = destinationB*180.0/Math.PI;
		destinationL = destinationL*180.0/Math.PI;
		
		System.out.println("B:" + destinationB);
		System.out.println("L:" + destinationL);
		System.out.println("H:" + destinationH);
		
		System.out.println("B1:" + getStrDegreeFromDecimalDegree(destinationB));
		System.out.println("L2:" + getStrDegreeFromDecimalDegree(destinationL));
	}
	
	public String getStrDegreeFromDecimalDegree(double angle ) {
		boolean bNegative = false;
		if (angle<1E-4 && Math.abs(angle)>1E-6)
		{
			bNegative = true;
		}

		//转化为度分秒
		double du, fen, miao;
		String tem = String.valueOf(Math.abs(angle));
		String[] temArray = tem.split("\\.");
		du = Integer.parseInt(temArray[0]);
		fen = Math.abs(angle) - du;
		
		double fenTem;
		fenTem = fen*60;
		tem = Double.toString(fenTem);
		temArray = tem.split("\\.");
		fen = Integer.parseInt(temArray[0]);
		miao = fenTem - fen;
		
		miao = miao*60;

		if (Math.abs(miao-60.0)<1E-4)
		{
			miao = 0.0;
			fen = fen+1.0;
			if (Math.abs(fen-60.0)<1E-4)
			{
				fen = 0.0;
				du += 1.0;
			}
		}

		//秒调整——等于60处理
		if (Math.abs(miao-60.0)<1E-5) {
			miao = 0;
			fen++;
		}

		//分调整——等于60处理
		if (Math.abs(fen-60)<1E-5) {
			fen = 0;
			du++;
		}
		///////////////////////////////

		String strangle;
		strangle = String.format("%03d°%02d′%03.2f″",(int)du,(int)fen,miao);
		
		if (bNegative) {
			strangle = String.format("-%s", strangle);
		}
		
		return strangle;
	}
}
