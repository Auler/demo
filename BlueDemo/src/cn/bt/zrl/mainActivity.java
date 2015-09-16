package cn.bt.zrl;

import java.util.Iterator;
import java.util.Set;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class mainActivity extends Activity {
    private Button mybutton = null;
    public void onCreate(Bundle savedInstanceState) 
    {
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.main);
    	//�õ���ť
    	mybutton = (Button)findViewById(R.id.btn2);
    	//�󶨼�����
    	mybutton.setOnClickListener(new ButtonListener());
	}


	//������������
	private class ButtonListener implements OnClickListener
	{
		public void onClick(View v)
		{
			//�õ�BluetoothAdapter����
			BluetoothAdapter adapter = BluetoothAdapter.getDefaultAdapter();
			//�ж�BluetoothAdapter�����Ƿ�Ϊ�գ����Ϊ�գ����������û�������豸
			if(adapter != null)
			{
					System.out.println("����ӵ�������豸");
					//����isEnabled()�����жϵ�ǰ�����豸�Ƿ����
					if(!adapter.isEnabled())
					{
						//��������豸�����õĻ�,����һ��intent����,�ö�����������һ��Activity,��ʾ�û���������������
						Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
						startActivity(intent);
					}
					//�õ������Ѿ���Ե���������������
					Set<BluetoothDevice> devices = adapter.getBondedDevices();
					if(devices.size()>0)    
					{
						//�õ���
						for(Iterator iterator = devices.iterator();iterator.hasNext();)
						{
							//�õ�BluetoothDevice����,Ҳ����˵�õ���Ե�����������
							BluetoothDevice device = (BluetoothDevice)iterator.next();
							//�õ�Զ�������豸�ĵ�ַ
							Log.d("mytag",device.getAddress());
						}
					}
			}
			else
			{
				System.out.println("û�������豸");
			}
		}
	}
}