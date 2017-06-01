package com.company;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * 
 * @author Erik Ren, Aditya Kuppili, Chris Kim
 * @version 5/31/17
 *
 */
public class AlphaTanksTest {

	/*
	 * BufferedImageLoader Test
	 */
	/**
	 * Tests ImageLoader
	 */
	@Test(expected = NullPointerException.class)
	public void bufferedImageImageLoadTest() {
		BufferedImageLoader test = new BufferedImageLoader();
		test.loadImage(null);
	}

	/*
	 * Bullet Tests
	 */
	/**
	 * Tests Bullet's Constructor
	 */
	@Test
	public void bulletConstructorTest() {
		Bullet test = new Bullet(ObjectId.Bullet);
		assertEquals(ObjectId.Bullet, test.getID());
	}

	/**
	 * Tests value setters
	 */
	@Test(expected = NullPointerException.class)
	public void bulletSetValuesTest() {
		Bullet test = new Bullet(ObjectId.Bullet);
		test.setValues(0, 0, null, 0, null, null);
	}

	/**
	 * Tests Initial vel setter
	 */
	@Test
	public void bulletSetInitialVelocityTest() {
		Bullet test = new Bullet(ObjectId.Bullet);
		test.setInitialVelocity(5);
		assertEquals(5, test.initialVelocity, 5);
	}

	/**
	 * Tests toString
	 */
	@Test
	public void bulletToStringTest() {
		Bullet test = new Bullet(ObjectId.Bullet);
		assertNull(test.toString());
	}

	/**
	 * Tests Bounds
	 */
	@Test
	public void bulletBoundsTest() {
		Bullet test = new Bullet(ObjectId.Bullet);
		assertNotNull(test.getBounds());
	}

	/**
	 * Tests BoundsTop
	 */
	@Test
	public void bulletBoundsTopTest() {
		Bullet test = new Bullet(ObjectId.Bullet);
		assertNotNull(test.getBoundsTop());
	}

	/**
	 * Tests BoundsRight
	 */
	@Test
	public void bulletBoundsRightTest() {
		Bullet test = new Bullet(ObjectId.Bullet);
		assertNotNull(test.getBoundsRight());
	}

	/**
	 * Tests BoundsLeft
	 */
	@Test
	public void bulletBoundsLeftTest() {
		Bullet test = new Bullet(ObjectId.Bullet);
		assertNotNull(test.getBoundsLeft());
	}

	/**
	 * Tests hit checker
	 */
	@Test(expected = NullPointerException.class)
	public void bulletHitTankTest() {
		Bullet test = new Bullet(ObjectId.Bullet);
		test.hitTank();
	}

	/**
	 * Tests hit checker for platforms
	 */
	@Test(expected = NullPointerException.class)
	public void bulletHitPlatformTest() {
		Bullet test = new Bullet(ObjectId.Bullet);
		test.hitPlatform();
	}

	/*
	 * Camera Tests
	 */
	/**
	 * Tests camera constructor
	 */
	@Test
	public void cameraConstructorTest() {
		Camera test = new Camera(0, 0);
		assertNotNull(test);
	}

	/**
	 * Tests y value getter
	 */
	@Test
	public void cameraGetYTest() {
		Camera test = new Camera(0, 0);
		assertEquals(0, test.getY(), 0);
	}

	/**
	 * Tests y value setter
	 */
	@Test
	public void cameraSetYTest() {
		Camera test = new Camera(0, 0);
		test.setY(1);
		assertEquals(1, test.getY(), 1);
	}

	/**
	 * Tests x value getter
	 */
	@Test
	public void cameraGetXTest() {
		Camera test = new Camera(0, 0);
		assertEquals(0, test.getX(), 0);
	}

	/**
	 * Tests x value setter
	 */
	@Test
	public void cameraSetXTest() {
		Camera test = new Camera(0, 0);
		test.setX(1);
		assertEquals(1, test.getX(), 0);
	}

	/*
	 * EnemyTank Tests
	 */
	/**
	 * Tests tank constructor
	 */
	@SuppressWarnings("unused")
	@Test(expected = NullPointerException.class)
	public void EnemyTankConstructorTest() {
		EnemyTank test = new EnemyTank(0, 0, null, null, null, null);
	}

	/**
	 * Tests tank constructor ID
	 */
	@Test(expected = NullPointerException.class)
	public void EnemyTankConstructor2Test() {
		EnemyTank test = new EnemyTank(ObjectId.EnemyTank);
		assertEquals(ObjectId.EnemyTank, test.getID());
	}

	/**
	 * Tests aim method
	 */
	@Test(expected = NullPointerException.class)
	public void EnemyTankAimTest() {
		EnemyTank test = new EnemyTank(ObjectId.EnemyTank);
		test.aim();
	}

	/**
	 * Tests fire method
	 */
	@Test(expected = NullPointerException.class)
	public void EnemyTankFireTest() {
		EnemyTank test = new EnemyTank(ObjectId.EnemyTank);
		test.fire();
	}

	/**
	 * Tests ai for same y plane
	 */
	@Test(expected = NullPointerException.class)
	public void EnemyTankHorizontalEnemyAction() {
		PlayerTank test = new PlayerTank(ObjectId.EnemyTank);
		EnemyTank test2 = new EnemyTank(ObjectId.EnemyTank);
		test2.horizontalEnemyAction(test);
	}

	/**
	 * Tests ai for differnt y plane
	 */
	@Test(expected = NullPointerException.class)
	public void EnemyTankPlatformEnemyAction() {
		PlayerTank test = new PlayerTank(ObjectId.EnemyTank);
		EnemyTank test2 = new EnemyTank(ObjectId.EnemyTank);
		test2.platformEnemyAction(test);
	}

	/*
	 * Flag Tests
	 */
	/**
	 * Tests flag constructor
	 */
	@Test
	public void flagConstructorTest() {
		Flag test = new Flag(0, 0, null);
		assertNotNull(test);
	}

	/**
	 * Tests toString
	 */
	@Test
	public void flagToStringTest() {
		Flag test = new Flag(0, 0, ObjectId.Flag);
		assertNull(test.toString());
	}

	/**
	 * Tests flag bounds
	 */
	@Test
	public void flagGetBoundsTest() {
		Flag test = new Flag(0, 0, null);
		assertNotNull(test.getBounds());
	}

	/*
	 * Game Tests
	 */
	/**
	 * Tests game starter
	 */
	@SuppressWarnings("null")
	@Test(expected = NullPointerException.class)
	public void gameStartTest() {
		Game game = null;
		game.start();
	}

	/**
	 * Tests current level getter
	 */
	@Test
	public void gameGetCurrentLevelTest() {
		Game game = new Game();
		assertEquals(1, game.getCurrentLevel());
	}

	/**
	 * Tests game initializer
	 */
	@SuppressWarnings("null")
	@Test(expected = NullPointerException.class)
	public void gameInitTest() {
		Game game = null;
		game.init();
	}

	/**
	 * Tests game runner
	 */
	@SuppressWarnings("null")
	@Test(expected = NullPointerException.class)
	public void gameRunTest() {
		Game game = null;
		game.run();
	}

	/**
	 * Tests level setter
	 */
	@Test
	public void gameSetCurrentLevelTest() {
		Game game = new Game();
		game.setCurrentLevel(0);
		assertEquals(0, game.getCurrentLevel());
	}

	/*
	 * Gun Tests
	 */
	/**
	 * Tests gun constructor
	 */
	@Test
	public void GunConstructorTest() {
		Gun test = new Gun(0, 0, null, 0, null, null);
		assertNotNull(test);
	}

	/**
	 * Tests toString
	 */
	@Test
	public void GunToStringTest() {
		Gun test = new Gun(0, 0, null, 0, null, null);
		assertEquals("Gun", test.toString());
	}

	/**
	 * Tests gun radius calculations
	 */
	@Test
	public void GunGetRadiusTest() {
		Gun test = new Gun(0, 0, null, 0, null, null);
		assertEquals(Math.sqrt(425), test.getRadius(), Math.sqrt(425));
	}

	/**
	 * Tests gun angle getter
	 */
	@Test
	public void GunGetAngleTest() {
		Gun test = new Gun(0, 0, null, 0, null, null);
		assertEquals(0, test.getAngle(), 0);
	}

	/**
	 * Tests gun angle setter
	 */
	@Test
	public void GunSetAngleTest() {
		Gun test = new Gun(0, 0, null, 0, null, null);
		test.setAngle(1);
		assertEquals(1, test.getAngle(), 1);
	}

	/**
	 * Tests player tank checker
	 */
	@Test(expected = NullPointerException.class)
	public void GunIsPlayerTankTest() {
		Gun test = new Gun(0, 0, null, 0, null, null);
		test.isPlayerTank();
	}

	/**
	 * Tests gun firing method
	 */
	@Test
	public void GunFireTest() {
		Gun test = new Gun(0, 0, null, 0, null, null);
		test.fire(null);
	}

	/**
	 * Tests enemy gun firing method
	 */
	@Test
	public void GunEnemyGunFireTest() {
		Gun test = new Gun(0, 0, null, 0, null, null);
		test.enemyGunFire(null);
	}

	/**
	 * Tests gun rotation
	 */
	@Test
	public void GunRotateIncreaseAngleTest() {
		Gun test = new Gun(0, 0, null, 0, null, null);
		test.rotateIncreaseAngle();
		;
		assertEquals(10, test.getAngle(), 10);
	}

	/**
	 * Tests gun rotation
	 */
	@Test
	public void GunRotateDecreaseAngleTest() {
		Gun test = new Gun(0, 0, null, 0, null, null);
		test.rotateDecreaseAngle();
		;
		assertEquals(-10, test.getAngle(), -10);
	}

	/**
	 * Tests bullet getter
	 */
	@Test
	public void GunGetBulletsTest() {
		Gun test = new Gun(0, 0, null, 0, null, null);
		assertNotNull(test.getBullets());
	}

	/**
	 * Tests enemy bullet getter
	 */
	@Test
	public void GunGetEnemyBulletsTest() {
		Gun test = new Gun(0, 0, null, 0, null, null);
		assertNotNull(test.getEnemyBullets1());
	}

	/*
	 * Handler Tests
	 */
	/**
	 * Tests level setter
	 */
	@Test
	public void HandlerSetCurrentLevel() {
		Handler test = new Handler();
		test.setCurrentLevel(0);
		assertEquals(0, test.currentLevel);
	}

	/**
	 * Tests object adding
	 */
	@Test
	public void HandlerAddObjectTest() {
		Handler test = new Handler();
		test.addObject(null);
	}

	/**
	 * Tests object removal
	 */
	@Test(expected = NullPointerException.class)
	public void HandlerRemoveObjectTest() {
		Handler test = new Handler();
		test.removeObject(null);
	}

	/**
	 * Tests level clearing
	 */
	@Test
	public void HandlerClearLevelTest() {
		Handler test = new Handler();
		test.clearLevel();
	}

	/**
	 * Tests level decision
	 */
	@Test
	public void HandlerDecideLevelTest() {
		Handler test = new Handler();
		test.decideLevel();
	}

	/*
	 * KeyInput Tests
	 */
	/**
	 * Tests key input constructor
	 */
	@Test
	public void KeyInputConstructorTest() {
		KeyInput test = new KeyInput(null);
		assertNotNull(test);
	}

	/**
	 * Tests key inputs
	 */
	@Test(expected = NullPointerException.class)
	public void KeyInputKeyPressedTest() {
		KeyInput test = new KeyInput(null);
		test.keyPressed(null);
	}

	/**
	 * Tests key released
	 */
	@Test(expected = NullPointerException.class)
	public void KeyInputKeyReleasedTest() {
		KeyInput test = new KeyInput(null);
		test.keyReleased(null);
	}

	/*
	 * Platform Tests
	 */
	/**
	 * Tests platform constructor
	 */
	@Test
	public void PlatformConstructorTest() {
		Platform test = new Platform(0, 0, null, null);
		assertNotNull(test);
	}

	/**
	 * Tests toString
	 */
	@Test
	public void PlatformToStringTest() {
		Platform test = new Platform(0, 0, null, null);
		assertEquals("Platform", test.toString());
	}

	/**
	 * Tests Platform Bounds
	 */
	@Test
	public void PlatformGetBoundsTest() {
		Platform test = new Platform(0, 0, null, null);
		assertNotNull(test.getBounds());
	}

	/*
	 * PlayerTank Tests
	 */
	/**
	 * Tests PlayerTank constructor
	 */
	@SuppressWarnings("unused")
	@Test(expected = NullPointerException.class)
	public void PlayerTankConstructor() {
		PlayerTank test = new PlayerTank(0, 0, null, null, null, null);
	}

	/**
	 * Tests PlayerTank ID constructor
	 */
	@Test
	public void PlayerTankConstructor2() {
		PlayerTank test = new PlayerTank(ObjectId.PlayerTank);
		assertEquals(ObjectId.PlayerTank, test.getID());
	}

	/*
	 * PowerUp Tests
	 */
	/**
	 * Tests PowerUp remove
	 */
	@Test
	public void PowerUpSetRemoveTest() {
		PowerUp test = new PowerUp(0, 0, null, null);
		test.setRemove(true);
		assertTrue(test.remove);
	}

	/**
	 * Tests PowerUp constructor
	 */
	@Test
	public void PowerUpConstructorTest() {
		PowerUp test = new PowerUp(0, 0, null, null);
		assertNotNull(test);
	}

	/**
	 * Tests toString
	 */
	@Test
	public void PowerUpToStringTest() {
		PowerUp test = new PowerUp(0, 0, null, null);
		assertNull(test.toString());
	}

	/**
	 * Tests PowerUp Bounds
	 */
	@Test
	public void PowerUpGetBoundsTest() {
		PowerUp test = new PowerUp(0, 0, null, null);
		assertNotNull(test.getBounds());
	}

	/*
	 * Tank Tests
	 */
	/**
	 * Tests Tank Constructor
	 */
	@Test(expected = NullPointerException.class)
	public void TankConstructorTest() {
		Tank test = new Tank(0, 0, null, null, null, null);
		assertNotNull(test);
	}

	/**
	 * Tests Tank Constructor ID
	 */
	@Test
	public void TankConstructor2Test() {
		Tank test = new Tank(ObjectId.PlayerTank);
		assertEquals(ObjectId.PlayerTank, test.getID());
	}

	/**
	 * Tests toString
	 */
	@Test
	public void TankToStringTest() {
		Tank test = new Tank(ObjectId.PlayerTank);
		assertEquals("Tank", test.toString());
	}

	/**
	 * Tests isPlayer checker
	 */
	@Test(expected = NullPointerException.class)
	public void TankIsPlayerTest() {
		Tank test = new Tank(0, 0, null, null, null, null);
		test.isPlayer();
	}

	/**
	 * Tests get gun method
	 */
	@Test(expected = NullPointerException.class)
	public void TankGetGunTest() {
		Tank test = new Tank(0, 0, null, null, null, null);
		test.getGun();
	}

	/**
	 * Tests tank bounds
	 */
	@Test
	public void TankGetBoundsTest() {
		Tank test = new Tank(ObjectId.PlayerTank);
		assertNotNull(test.getBounds());
	}

	/**
	 * Tests tank bounds left
	 */
	@Test
	public void TankGetBoundsLeftTest() {
		Tank test = new Tank(ObjectId.PlayerTank);
		assertNotNull(test.getBoundsLeft());
	}

	/**
	 * Tests tank bounds right
	 */
	@Test
	public void TankGetBoundsRightTest() {
		Tank test = new Tank(ObjectId.PlayerTank);
		assertNotNull(test.getBoundsRight());
	}

	/**
	 * Tests enemy data getter
	 */
	@Test
	public void TankGetEnemyTankDataTest() {
		Tank test = new Tank(ObjectId.PlayerTank);
		test.getEnemyTankData();
	}

	/**
	 * Tests health getter
	 */
	@Test
	public void TankGetHealthTest() {
		Tank test = new Tank(ObjectId.PlayerTank);
		assertEquals(3, test.getHealth());
	}

	/**
	 * Tests health setter
	 */
	@Test
	public void TankSetHealthTest() {
		Tank test = new Tank(ObjectId.PlayerTank);
		test.setHealth(1);
		assertEquals(1, test.getHealth());
	}

	/**
	 * Tests collision
	 */
	@Test(expected = NullPointerException.class)
	public void TankCollisionTest() {
		Tank test = new Tank(ObjectId.PlayerTank);
		test.collision();
	}

	/**
	 * Tests right collision
	 */
	@Test
	public void TankIsRightCrashedTest() {
		Tank test = new Tank(ObjectId.PlayerTank);
		assertFalse(test.isRightCrashed());
	}

	/*
	 * Window Test
	 */
	/**
	 * Tests window constructor
	 */
	@SuppressWarnings("unused")
	@Test(expected = NullPointerException.class)
	public void WindowConstructorTest() {
		Window test = new Window(0, 0, null, null);

	}

	/**
	 * Tests update window
	 */
	@Test(expected = NullPointerException.class)
	public void WindowUpdateTest() {
		Window test = new Window(0, 0, null, null);
		test.update();
	}
}
