import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.moon.vip.application.major.MajorFrameMapper;
import com.moon.vip.model.major.ColonyAndBranch;
import com.moon.vip.model.major.MajorFrame;
import com.moon.vip.service.major.IMajorFrameService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:META-INF/spring/root-test.xml")
public class TestMajorFrameServiceImpl {
	
	@Autowired
	IMajorFrameService majorFrameService;
	@Autowired
	MajorFrameMapper majorFrameMapper;
	//测试重命名
	@Test
	public void testRename(){
//		ClassPathXmlApplicationContext classPathXmlApplicationContext=new ClassPathXmlApplicationContext();
//		IMajorFrameService  majorFrameService=(IMajorFrameService) classPathXmlApplicationContext.getBean("majorFrameService");
		MajorFrame majorFrame=new MajorFrame();
		System.out.println(majorFrameService);
		majorFrame.setId(0);
		majorFrame.setName("软件测试部");
		/*int i=majorFrameService.rename(majorFrame);
		System.out.println(i);*/
	}
	
	//测试校验用户名是否存在
	@Test
	public void testCheckNameIsNotExist(){
		String name="全部事业群";
//		int i=majorFrameService.checkNameIsNotExist(name);
//		System.out.println(i);
	}
	
	//测试校验父节点下是否有子节点
	@Test
	public void testCheckPidIsNotExistChildId(){
		Integer id=1;
		int i=majorFrameService.checkPidIsNotExistChildId(id);
		System.out.println(i);
	}
	
	
	//测试获取最大排列顺序的值
	@Test
	public void testGetMaxOrder(){
		
		//System.out.println(majorFrameMapper.getMaxOrder());
	}
	
	@Test
	public void testSelectInfoById(){
		MajorFrame major=new MajorFrame();
		major.setId(1);
		/*List<MajorFrame> list=majorFrameMapper.selectInfoById(major);
		for (MajorFrame m:list){
			System.out.println(m.toString());
		}*/
	}
	
	
	
//	@Test
//	public void testSelectAdviserByCode(){
//		ColonyAndBranch cab=new ColonyAndBranch();
//		List<String> adviserList=new ArrayList<String>();
//		adviserList.add("00239");
//		adviserList.add("00657");
//		adviserList.add("00604");
//		cab.setAdviserList(adviserList);
//		List<ColonyAndBranch> list=majorFrameMapper.selectAdviserByCode(cab);
//		for (ColonyAndBranch s:list){
//			System.out.println(s);
//		}
//	}
}