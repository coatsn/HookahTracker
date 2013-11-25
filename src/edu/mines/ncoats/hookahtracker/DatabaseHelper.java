package edu.mines.ncoats.hookahtracker;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {

	// Logcat Tag
	private static final String LOG = "DatabaseHelper";

	// db version
	private static final int DATABASE_VERSION = 1;

	// db name
	private static final String DATABASE_NAME = "hookahTracker";

	// Table names
	private static final String TABLE_HOOKAHS = "hookahs";
	private static final String TABLE_SHISHA_BRANDS = "shisha_brands";
	private static final String TABLE_SHISHAS = "shishas";
	private static final String TABLE_BOWLS = "bowls";
	private static final String TABLE_COALS = "coals";
	private static final String TABLE_SESSIONS = "sessions";

	// Common column names
	private static final String KEY_ID = "id";
	private static final String KEY_NAME = "name";

	// HOOKAHS Table - column names
	private static final String KEY_HEIGHT = "height";
	private static final String KEY_NUM_HOSES = "num_hoses";
	private static final String KEY_NUM_BOWLS = "num_bowls";

	// SHISHAS table - column names
	private static final String KEY_BRAND_ID = "brand_id";
	private static final String KEY_GRAMS = "grams";

	// BOWLS table - column names
	private static final String KEY_SIZE = "size";

	// COALS table - column names
	private static final String KEY_NUM = "num";

	// SESSIONS table - column names
	private static final String KEY_HOOKAH_ID = "hookah_id";
	private static final String KEY_BOWL_ID = "bowl_id";
	private static final String KEY_SHISHA_ID = "shisha_id";
	private static final String KEY_NUM_COALS = "num_coals";
	private static final String KEY_DATE = "date";

	private static final String CREATE_TABLE_HOOKAHS = "CREATE TABLE IF NOT EXISTS "
			+ TABLE_HOOKAHS + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
			+ KEY_NAME + " TEXT," +  KEY_HEIGHT + " INTEGER," + KEY_NUM_HOSES 
			+ " INTEGER," + KEY_NUM_BOWLS + " INTEGER" + ")";

	private static final String CREATE_TABLE_SHISHA_BRANDS = 
			"CREATE TABLE IF NOT EXISTS " + TABLE_SHISHA_BRANDS + "("
					+ KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_NAME
					+ " TEXT" + ")";

	private static final String CREATE_TABLE_SHISHAS = 
			"CREATE TABLE IF NOT EXISTS " + TABLE_SHISHAS + "(" + KEY_ID 
			+ " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_NAME + " TEXT,"
			+ KEY_BRAND_ID + " INTEGER," + KEY_GRAMS + " INTEGER" + ")";

	private static final String CREATE_TABLE_BOWLS = 
			"CREATE TABLE IF NOT EXISTS " + TABLE_BOWLS + "(" + KEY_ID
			+ " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_NAME + " TEXT,"
			+ KEY_SIZE + " INTEGER" + ")";

	private static final String CREATE_TABLE_COALS = 
			"CREATE TABLE IF NOT EXISTS " + TABLE_COALS + "(" + KEY_ID
			+ " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_NAME + " TEXT,"
			+ KEY_NUM + " INTEGER" + ")";

	private static final String CREATE_TABLE_SESSIONS = 
			"CREATE TABLE IF NOT EXISTS " + TABLE_SESSIONS + "(" + KEY_ID
			+ " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_NAME + " TEXT,"
			+ KEY_HOOKAH_ID + " INTEGER," + KEY_BOWL_ID + " INTEGER,"
			+ KEY_SHISHA_ID + " INTEGER," + KEY_NUM_COALS + "INTEGER,"
			+ KEY_DATE + " DATETIME" + ")";

	public DatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {

		//Creates all the tables
		db.execSQL(CREATE_TABLE_HOOKAHS);
		db.execSQL(CREATE_TABLE_SHISHA_BRANDS);
		db.execSQL(CREATE_TABLE_SHISHAS);
		db.execSQL(CREATE_TABLE_BOWLS);
		db.execSQL(CREATE_TABLE_COALS);
		db.execSQL(CREATE_TABLE_SESSIONS);

	}

	@Override
	public void onUpgrade (SQLiteDatabase db, int oldVersion, int newVersion) {

		db.execSQL("DROP TABLE IF EXISTS " + TABLE_HOOKAHS);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_SHISHA_BRANDS);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_SHISHAS);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_BOWLS);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_COALS);
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_SESSIONS);

		onCreate (db);

	}

	public void closeDB() {
		SQLiteDatabase db = this.getReadableDatabase();
		if (db != null && db.isOpen()) db.close();
	}

	// From: http://www.androidhive.info/2013/09/android-sqlite-database-with-multiple-tables/
	private String getDateTime() {
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss", Locale.getDefault());
		Date date = new Date();
		return dateFormat.format(date);
	}

	public void createHookah(Hookah hookah) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(KEY_NAME, hookah.getName());
		values.put(KEY_HEIGHT, hookah.getHeight());
		values.put(KEY_NUM_HOSES, hookah.getNumHoses());
		values.put(KEY_NUM_BOWLS, hookah.getNumBowls());

		db.insert(TABLE_HOOKAHS, null, values);
	}

	public ArrayList<Hookah> getAllHookahs() {
		ArrayList<Hookah> hookahs = new ArrayList<Hookah>();
		String selectQuery = "SELECT * FROM " + TABLE_HOOKAHS;

		Log.e(LOG, selectQuery, null);

		SQLiteDatabase db = this.getReadableDatabase();
		Cursor c = db.rawQuery(selectQuery, null);

		if (c.moveToFirst()) {
			do {

				Hookah hookah = new Hookah();
				hookah.setId(c.getInt(c.getColumnIndex(KEY_ID)));
				hookah.setName(c.getString(c.getColumnIndex(KEY_NAME)));
				hookah.setHeight(c.getInt(c.getColumnIndex(KEY_HEIGHT)));
				hookah.setNumHoses(c.getInt(c.getColumnIndex(KEY_NUM_HOSES)));

				hookahs.add(hookah);

			} while (c.moveToNext()) ;
		}

		return hookahs;

	}

	public void clearDB() {
		SQLiteDatabase db = this.getReadableDatabase();

		db.delete(TABLE_HOOKAHS, null, null);
		db.delete(TABLE_SHISHA_BRANDS, null, null);
		db.delete(TABLE_SHISHAS, null, null);
		db.delete(TABLE_BOWLS, null, null);
		db.delete(TABLE_COALS, null, null);
		db.delete(TABLE_SESSIONS, null, null);
	}

	public Hookah getHookahByName(String name) {
		SQLiteDatabase db = this.getReadableDatabase();
		String selectQuery = "SELECT * FROM " + TABLE_HOOKAHS + " WHERE "
				+ KEY_NAME + " = '" + name + "'";

		Log.e(LOG, selectQuery);

		Cursor c = db.rawQuery(selectQuery, null);

		if (c != null) c.moveToFirst();

		Hookah hookah = new Hookah();
		hookah.setId(c.getInt(c.getColumnIndex(KEY_ID)));
		hookah.setName(c.getString(c.getColumnIndex(KEY_NAME)));
		hookah.setHeight(c.getInt(c.getColumnIndex(KEY_HEIGHT)));
		hookah.setNumHoses(c.getInt(c.getColumnIndex(KEY_NUM_HOSES)));

		return hookah;
	}

	public void deleteHookah(Hookah hookah) {
		SQLiteDatabase db = this.getWritableDatabase();

		db.delete(TABLE_HOOKAHS, KEY_NAME + " = ?", 
				new String[] { hookah.getName() });
	}

	public void createShishaBrand(ShishaBrand sb) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(KEY_NAME, sb.getName());

		db.insert(TABLE_SHISHA_BRANDS, null, values);
	}

	public ArrayList<ShishaBrand> getAllShishaBrands() {
		ArrayList<ShishaBrand> shishaBrands = new ArrayList<ShishaBrand>();
		String selectQuery = "SELECT * FROM " + TABLE_SHISHA_BRANDS;

		Log.e(LOG, selectQuery, null);

		SQLiteDatabase db = this.getReadableDatabase();
		Cursor c = db.rawQuery(selectQuery, null);

		if (c.moveToFirst()) {
			do {

				ShishaBrand sb = new ShishaBrand();
				sb.setId(c.getInt(c.getColumnIndex(KEY_ID)));
				sb.setName(c.getString(c.getColumnIndex(KEY_NAME)));

				shishaBrands.add(sb);

			} while (c.moveToNext()) ;
		}

		Log.d("length log", "the length is: " + shishaBrands.size());
		return shishaBrands;
	}

	public void createShisha(Shisha shisha) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(KEY_NAME, shisha.getName());
		values.put(KEY_BRAND_ID, shisha.getBrandId());
		values.put(KEY_GRAMS, shisha.getGrams());

		db.insert(TABLE_SHISHAS, null, values);
	}

	public ArrayList<Shisha> getAllShishaFlavors(int brandId) {
		ArrayList<Shisha> shishas = new ArrayList<Shisha>();
		String selectQuery = "SELECT * FROM " + TABLE_SHISHAS 
				+ " WHERE " + KEY_BRAND_ID + " = '" 
				+ brandId + "'";

		Log.e(LOG, selectQuery, null);

		SQLiteDatabase db = this.getReadableDatabase();
		Cursor c = db.rawQuery(selectQuery, null);

		if (c.moveToFirst()) {
			do {

				Shisha shisha = new Shisha();
				shisha.setId(c.getInt(c.getColumnIndex(KEY_ID)));
				shisha.setName(c.getString(c.getColumnIndex(KEY_NAME)));
				shisha.setBrandId(c.getInt(c.getColumnIndex(KEY_BRAND_ID)));
				shisha.setGrams(c.getInt(c.getColumnIndex(KEY_GRAMS)));

				shishas.add(shisha);

			} while (c.moveToNext()) ;
		}

		return shishas;
	}

	public void deleteShisha(Shisha shisha) {
		SQLiteDatabase db = this.getWritableDatabase();

		db.delete(TABLE_SHISHAS, KEY_NAME + " = ?", 
				new String[] { shisha.getName() });
	}


}
