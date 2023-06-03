;;; Sierra Script 1.0 - (do not remove this comment)
(script# 994)
(include sci.sh)
(use Main)
(use Print)
(use Polygon)
(use Sound)
(use SRDialog)
(use Cycle)
(use InvI)
(use User)
(use Obj)


(procedure (localproc_0dae param1 &tmp temp0 [temp1 40] [temp41 40] temp81 [temp82 40] [temp122 10] [temp132 5])
	(= temp81 (Memory memALLOC_CRIT 150))
	(= temp0 1)
	(DeviceInfo 0 global29 @temp1)
	(DeviceInfo 1 @temp41)
	(if
		(and
			(DeviceInfo 3 @temp41)
			(or
				(DeviceInfo 2 @temp1 @temp41)
				(not (DeviceInfo 6 (gGame name?)))
			)
		)
		(Message msgGET 994 6 0 0 1 @temp82)
		(Message msgGET 994 7 0 0 1 @temp122)
		(Message msgGET 994 8 0 0 1 @temp132)
		(Format
			temp81
			@temp82
			(if param1 @temp122 else @temp132)
			@temp1
		)
		(Load rsFONT gFont)
		(DeviceInfo 4)
		(Message msgGET 994 2 0 0 1 @temp82)
		(Message msgGET 994 4 0 0 1 @temp122)
		(Message msgGET 994 5 0 0 1 @temp132)
		(if
			(==
				(= temp0
					(if param1
						(Print
							font: 0
							addText: temp81
							addButton: 1 @temp82 0 40
							addButton: 0 @temp122 30 40
							addButton: 2 @temp132
							init:
						)
					else
						(Print
							font: 0
							addText: temp81
							addButton: 1 @temp82 0 40
							init:
						)
					)
				)
				2
			)
			(= temp0 (proc990_0 global29))
		)
	)
	(Memory memFREE temp81)
	(return temp0)
)

(instance cast of EventHandler
	(properties)
)

(instance features of EventHandler
	(properties)
)

(instance theDoits of EventHandler
	(properties)
)

(class Sounds of EventHandler
	(properties
		elements 0
		size 0
	)
	
	(method (pause param1)
		(self
			eachElementDo: #perform mayPause (if argc param1 else 1)
		)
	)
)

(instance mayPause of Code
	(properties)
	
	(method (doit param1 param2)
		(if (not (& (param1 flags?) $0001))
			(param1 pause: param2)
		)
	)
)

(instance regions of EventHandler
	(properties)
)

(instance addToPics of EventHandler
	(properties)
	
	(method (doit)
		(self eachElementDo: #perform aTOC)
		(AddToPic elements)
	)
)

(instance timers of Set
	(properties)
)

(instance mouseDownHandler of EventHandler
	(properties)
)

(instance keyDownHandler of EventHandler
	(properties)
)

(instance directionHandler of EventHandler
	(properties)
)

(instance walkHandler of EventHandler
	(properties)
)

(class Cue of Obj
	(properties
		cuee 0
		cuer 0
		register 0
	)
	
	(method (doit)
		(global18 delete: self)
		(if (global18 isEmpty:)
			(global18 dispose:)
			(= global18 0)
		)
		(cuee cue: register cuer)
		(self dispose:)
	)
)

(instance aTOC of Code
	(properties)
	
	(method (doit param1 &tmp temp0 temp1)
		(if (not (& (param1 signal?) $4000))
			(= temp0
				(+ (gEgo xStep?) (/ (CelWide (gEgo view?) 2 0) 2))
			)
			(= temp1 (* (gEgo yStep?) 2))
			(global2
				addObstacle:
					((Polygon new:)
						init:
							(- (param1 brLeft?) temp0)
							(- (CoordPri 1 (CoordPri (param1 y?))) temp1)
							(+ (param1 brRight?) temp0)
							(- (CoordPri 1 (CoordPri (param1 y?))) temp1)
							(+ (param1 brRight?) temp0)
							(+ (param1 y?) temp1)
							(- (param1 brLeft?) temp0)
							(+ (param1 y?) temp1)
						yourself:
					)
			)
		)
	)
)

(class Game of Obj
	(properties
		script 0
		printLang 1
		_detailLevel 3
		panelObj 0
		panelSelector 0
	)
	
	(method (init)
		Motion
		Sound
		((= gCast cast) add:)
		((= gFeatures features) add:)
		((= gSounds Sounds) add:)
		((= gRegions regions) add:)
		((= gAddToPics addToPics) add:)
		((= gTimers timers) add:)
		((= gTheDoits theDoits) add:)
		((= gEcoMouseDownHandler mouseDownHandler) add:)
		((= gEcoKeyDownHandler keyDownHandler) add:)
		((= gEcoDirectionHandler directionHandler) add:)
		((= gWalkHandler walkHandler) add:)
		(= gNewEventHandler 0)
		(= global29 (GetSaveDir))
		(Inv init:)
		(if (not gUser) (= gUser User))
		(gUser init:)
	)
	
	(method (doit &tmp newEvent thePanelObj thePanelSelector)
		(if panelObj
			(= thePanelObj panelObj)
			(= thePanelSelector panelSelector)
			(= panelObj (= panelSelector 0))
			(proc999_7 thePanelObj thePanelSelector)
		)
		(= gCycleCnt (+ global86 (GetTime)))
		(if gNewEventHandler
			(while gNewEventHandler
				(gNewEventHandler eachElementDo: #doit)
				(if
					(and
						((= newEvent (Event new:)) type?)
						gNewEventHandler
					)
					(gNewEventHandler firstTrue: #handleEvent newEvent)
				)
				(newEvent dispose:)
				(= gCycleCnt (+ global86 (GetTime)))
				(gSounds eachElementDo: #check)
			)
		)
		(if global92
			(global92 eachElementDo: #doit)
			(if (not gTheNewEcoDialog)
				(if
				(and ((= newEvent (Event new:)) type?) global92)
					(global92 firstTrue: #handleEvent newEvent)
				)
				(newEvent dispose:)
				(= gCycleCnt (+ global86 (GetTime)))
				(return)
			)
		)
		(gSounds eachElementDo: #check)
		(gTimers eachElementDo: #doit)
		(if gTheNewEcoDialog (gTheNewEcoDialog check:))
		(Animate (gCast elements?) 1)
		(if global37
			(= global37 0)
			(gCast eachElementDo: #motionCue)
		)
		(if global18 (global18 eachElementDo: #doit))
		(if script (script doit:))
		(gRegions eachElementDo: #doit)
		(if (== gNewRoomNumber gNumber) (gUser doit:))
		(gTheDoits doit:)
		(if (!= gNewRoomNumber gNumber)
			(self newRoom: gNewRoomNumber)
		)
		(gTimers eachElementDo: #delete)
		(GameIsRestarting 0)
	)
	
	(method (play)
		(= gGame self)
		(= global29 (GetSaveDir))
		(self setCursor: gWaitC 1 init:)
		(self setCursor: gArrowC 1)
		(while (not global4)
			(self doit:)
		)
	)
	
	(method (replay &tmp temp0)
		(if gPEvent (gPEvent dispose:))
		(if gTheNewEcoDialog (gTheNewEcoDialog dispose:))
		(gCast eachElementDo: #perform RU)
		(gGame setCursor: gWaitC 1)
		(= temp0
			(if
			(not (proc999_5 (global2 style?) -1 11 12 13 14))
				(global2 style?)
			else
				100
			)
		)
		(DrawPic (global2 curPic?) temp0 dpCLEAR)
		(if (!= gPicNumber -1)
			(DrawPic gPicNumber dpOPEN_NO_TRANSITION dpNO_CLEAR)
		)
		(gAddToPics doit:)
		(cond 
			((not (User canControl:)) (gGame setCursor: gWaitC))
			((and gIconBar (gIconBar curIcon?)) (gGame setCursor: ((gIconBar curIcon?) cursor?)))
			(else (gGame setCursor: gArrowC))
		)
		(SL doit:)
		(DoSound sndRESTORE)
		(Sound pause: 0)
		(= global86 (- gCycleCnt (GetTime)))
		(while (not global4)
			(self doit:)
		)
	)
	
	(method (newRoom newRoomNumber &tmp [temp0 5] temp5)
		(gAddToPics
			eachElementDo: #dispose
			eachElementDo: #delete
			release:
		)
		(gFeatures eachElementDo: #perform fDC release:)
		(gCast eachElementDo: #dispose eachElementDo: #delete)
		(gTimers eachElementDo: #delete)
		(gRegions eachElementDo: #perform DNKR release:)
		(gTheDoits release:)
		(Animate 0)
		(= gSouth gNumber)
		(= gNumber newRoomNumber)
		(= gNewRoomNumber newRoomNumber)
		(FlushResources newRoomNumber)
		(self startRoom: gNumber)
		(while ((= temp5 (Event new: 3)) type?)
			(temp5 dispose:)
		)
		(temp5 dispose:)
	)
	
	(method (startRoom param1)
		(if global14 (SetDebug))
		(gRegions addToFront: (= global2 (ScriptID param1)))
		(global2 init:)
	)
	
	(method (restart)
		(if gTheNewEcoDialog (gTheNewEcoDialog dispose:))
		(RestartGame)
	)
	
	(method (restore &tmp [temp0 20] temp20 temp21 [temp22 100] [temp122 5] [temp127 100])
		(if (not (ValidPath global29))
			(Message msgGET 994 9 0 0 1 @temp22)
			(Format @temp127 @temp22 global29)
			(Print font: 0 addText: @temp127 init:)
			(proc990_0 global29)
		)
		(Load rsFONT global23)
		(ScriptID 990)
		(= temp21 (self setCursor: 999 1))
		(Sound pause: 1)
		(if (localproc_0dae 1)
			(if gTheNewEcoDialog (gTheNewEcoDialog dispose:))
			(if (!= (= temp20 (Restore doit: &rest)) -1)
				(self setCursor: gWaitC 1)
				(if (CheckSaveGame name temp20 global27)
					(RestoreGame name temp20 global27)
				else
					(Message msgGET 994 3 0 0 1 @temp22)
					(Message msgGET 994 2 0 0 1 @temp122)
					(Print
						font: 0
						addText: @temp22
						addButton: 1 @temp122 0 40
						init:
					)
				)
			)
			(localproc_0dae 0)
		)
		(self setCursor: temp21 (HaveMouse))
		(Sound pause: 0)
	)
	
	(method (save &tmp [temp0 20] temp20 temp21 [temp22 100] [temp122 5] [temp127 100])
		(if (not (ValidPath global29))
			(Message msgGET 994 9 0 0 1 @temp22)
			(Format @temp127 @temp22 global29)
			(Print font: 0 addText: @temp127 init:)
			(proc990_0 global29)
		)
		(Load rsFONT global23)
		(ScriptID 990)
		(= temp21 (self setCursor: 999 1))
		(Sound pause: 1)
		(if (localproc_0dae 1)
			(if gTheNewEcoDialog (gTheNewEcoDialog dispose:))
			(if (!= (= temp20 (Save doit: @temp0)) -1)
				(self setCursor: gWaitC 1)
				(if (not (SaveGame name temp20 @temp0 global27))
					(Message msgGET 994 1 0 0 1 @temp22)
					(Message msgGET 994 2 0 0 1 @temp122)
					(Print
						font: 0
						addText: @temp22
						addButton: 1 @temp122 0 40
						init:
					)
				)
			)
			(localproc_0dae 0)
		)
		(self setCursor: temp21 (HaveMouse))
		(Sound pause: 0)
	)
	
	(method (changeScore param1)
		(= global15 (+ global15 param1))
		(SL doit:)
	)
	
	(method (handleEvent pEvent)
		(cond 
			((pEvent claimed?) 1)
			((and script (script handleEvent: pEvent)) 1)
			((& (pEvent type?) evVERB) (self pragmaFail:))
		)
		(pEvent claimed?)
	)
	
	(method (showMem &tmp [temp0 100])
		(Format
			@temp0
			{Free Heap: %u Bytes\nLargest ptr: %u Bytes\nFreeHunk: %u KBytes\nLargest hunk: %u Bytes}
			(MemoryInfo 1)
			(MemoryInfo 0)
			(>> (MemoryInfo 3) $0006)
			(MemoryInfo 2)
		)
		(Print addText: @temp0 init:)
	)
	
	(method (setCursor cursorNumber param2 param3 param4 param5 param6 &tmp theGCursorNumber)
		(= theGCursorNumber gCursorNumber)
		(if (IsObject cursorNumber)
			(= gCursorNumber cursorNumber)
			(cursorNumber init:)
		else
			(SetCursor cursorNumber 0 0)
		)
		(if (> argc 1)
			(SetCursor param2)
			(if (> argc 2)
				(SetCursor param3 param4)
				(if (> argc 4)
					(SetCursor cursorNumber 0 0 param5 param6)
				)
			)
		)
		(return theGCursorNumber)
	)
	
	(method (notify)
	)
	
	(method (setScript theScript)
		(if script (script dispose:))
		(if theScript (theScript init: self &rest))
	)
	
	(method (cue)
		(if script (script cue:))
	)
	
	(method (quitGame param1)
		(if (or (not argc) param1) (= global4 1))
	)
	
	(method (masterVolume param1)
		(if argc
			(DoSound sndMASTER_VOLUME param1)
		else
			(DoSound sndMASTER_VOLUME)
		)
	)
	
	(method (detailLevel the_detailLevel)
		(if argc
			(= _detailLevel the_detailLevel)
			(gCast eachElementDo: #checkDetail)
		)
		(return _detailLevel)
	)
	
	(method (pragmaFail)
	)
)

(class Rgn of Obj
	(properties
		script 0
		number 0
		modNum -1
		noun 0
		timer 0
		keep 0
		initialized 0
	)
	
	(method (init)
		(if (not initialized)
			(= initialized 1)
			(if (not (gRegions contains: self))
				(gRegions addToEnd: self)
			)
			(super init:)
		)
	)
	
	(method (doit)
		(if script (script doit:))
	)
	
	(method (dispose)
		(gRegions delete: self)
		(if (IsObject script) (script dispose:))
		(if (IsObject timer) (timer dispose: delete:))
		(gSounds eachElementDo: #clean self)
		(DisposeScript number)
	)
	
	(method (handleEvent pEvent)
		(cond 
			((pEvent claimed?) 1)
			(
				(not
					(if
					(and script (or (script handleEvent: pEvent) 1))
						(pEvent claimed?)
					)
				)
				(pEvent claimed: (self doVerb: (pEvent message?)))
			)
		)
		(pEvent claimed?)
	)
	
	(method (doVerb theVerb &tmp temp0)
		(if (== modNum -1) (= modNum gNumber))
		(return
			(if (Message msgGET modNum noun theVerb 0 1)
				(global91 say: noun theVerb 0 0 0 modNum)
			else
				(return 0)
			)
		)
	)
	
	(method (setScript theScript)
		(if (IsObject script) (script dispose:))
		(if theScript (theScript init: self &rest))
	)
	
	(method (cue)
		(if script (script cue:))
	)
	
	(method (newRoom)
	)
	
	(method (notify)
	)
)

(class Rm of Rgn
	(properties
		script 0
		number 0
		modNum -1
		noun 0
		timer 0
		keep 0
		initialized 0
		picture 0
		style $ffff
		horizon 0
		controls 0
		north 0
		east 0
		south 0
		west 0
		curPic 0
		picAngle 0
		vanishingX 160
		vanishingY 0
		obstacles 0
		inset 0
	)
	
	(method (init)
		(= number gNumber)
		(= gPicAngle picAngle)
		(if picture (self drawPic: picture))
		(self
			reflectPosn: (gUser alterEgo?) ((gUser alterEgo?) edgeHit?)
		)
		((gUser alterEgo?) edgeHit: 0)
	)
	
	(method (doit &tmp temp0)
		(if script (script doit:))
		(if
			(= temp0
				(self edgeToRoom: ((gUser alterEgo?) edgeHit?))
			)
			(self newRoom: temp0)
		)
	)
	
	(method (dispose)
		(if obstacles (obstacles dispose:))
		(super dispose:)
	)
	
	(method (handleEvent pEvent)
		(if (and inset (inset handleEvent: pEvent))
		else
			(super handleEvent: pEvent)
		)
		(pEvent claimed?)
	)
	
	(method (newRoom newRoomNumber)
		(gRegions
			delete: self
			eachElementDo: #newRoom newRoomNumber
			addToFront: self
		)
		(= gNewRoomNumber newRoomNumber)
		(super newRoom: newRoomNumber)
	)
	
	(method (setRegions scriptNumbers &tmp temp0 theScriptNumbers temp2)
		(= temp0 0)
		(while (< temp0 argc)
			(= theScriptNumbers [scriptNumbers temp0])
			((= temp2 (ScriptID theScriptNumbers))
				number: theScriptNumbers
			)
			(gRegions add: temp2)
			(if (not (temp2 initialized?)) (temp2 init:))
			(++ temp0)
		)
	)
	
	(method (drawPic picNumber picAnimation)
		(if gAddToPics
			(gAddToPics eachElementDo: #dispose release:)
		)
		(= curPic picNumber)
		(= gPicNumber -1)
		(DrawPic
			picNumber
			(cond 
				((== argc 2) picAnimation)
				((!= style -1) style)
				(else 100)
			)
			dpCLEAR
		)
	)
	
	(method (overlay picNumber picAnimation)
		(= gPicNumber picNumber)
		(DrawPic
			picNumber
			(cond 
				((== argc 2) picAnimation)
				((!= style -1) style)
				(else 100)
			)
			dpNO_CLEAR
		)
	)
	
	(method (addObstacle param1)
		(if (not (IsObject obstacles))
			(= obstacles (List new:))
		)
		(obstacles add: param1 &rest)
	)
	
	(method (reflectPosn param1 param2)
		(switch param2
			(1 (param1 y: 188))
			(4
				(param1 x: (- 319 (param1 xStep?)))
			)
			(3
				(param1 y: (+ horizon (param1 yStep?)))
			)
			(2 (param1 x: 1))
		)
	)
	
	(method (edgeToRoom param1)
		(switch param1
			(1 north)
			(2 east)
			(3 south)
			(4 west)
		)
	)
	
	(method (roomToEdge param1)
		(switch param1
			(north 1)
			(south 3)
			(east 2)
			(west 4)
		)
	)
	
	(method (setInset param1 param2 param3)
		(if inset (inset dispose:))
		(if (and argc param1)
			(param1
				init:
					(if (>= argc 2) param2 else 0)
					self
					(if (>= argc 3) param3 else 0)
			)
		)
	)
)

(class SL of Obj
	(properties
		state $0000
		code 0
	)
	
	(method (doit &tmp temp0)
		(if code
			(= temp0 (Memory memALLOC_CRIT 150))
			(code doit: temp0)
			(DrawStatus (if state temp0 else 0))
			(Memory memFREE temp0)
		)
	)
	
	(method (enable)
		(= state 1)
		(self doit:)
	)
	
	(method (disable)
		(= state 0)
		(self doit:)
	)
)

(instance RU of Code
	(properties)
	
	(method (doit param1 &tmp temp0)
		(if (param1 underBits?)
			(= temp0
				(&
					(= temp0 (| (= temp0 (param1 signal?)) $0001))
					$fffb
				)
			)
			(param1 underBits: 0 signal: temp0)
		)
	)
)

(instance DNKR of Code
	(properties)
	
	(method (doit param1)
		(if (not (param1 keep?)) (param1 dispose:))
	)
)

(instance fDC of Code
	(properties)
	
	(method (doit param1)
		(if (param1 respondsTo: #delete)
			(param1
				signal: (& (param1 signal?) $ffdf)
				dispose:
				delete:
			)
		else
			(param1 dispose:)
		)
	)
)
