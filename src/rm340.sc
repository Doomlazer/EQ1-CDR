;;; Sierra Script 1.0 - (do not remove this comment)
(script# 340)
(include sci.sh)
(use Main)
(use HandsOffScript)
(use EcoRoom)
(use n819)
(use Polygon)
(use Cycle)
(use Obj)

(public
	rm340 0
)

(local
	[local0 14] = [-1 -1 -30 29 15 360 67 -30 108 4096 0 290 210 -32768]
	[local14 16] = [-1 0 -20 300 0 -30 30 360 35 4096 15 -30 168 195 360 -32768]
	[local30 16] = [-1 1 360 170 15 -20 210 360 183 160 167 8192 -1 -30 177 16384]
)
(instance rm340 of EcoRoom
	(properties
		picture 340
		style $8007
		horizon 15
		north 322
		south 260
		walkOffTop 1
		lookStr 1
	)
	
	(method (init)
		(= global250 3)
		(proc819_6)
		(proc819_7)
		(gEgo init: x: 170 ignoreHorizon:)
		(gDelph
			z: 0
			x: 150
			setPri: 14
			setStep: 4 6
			ignoreHorizon:
			setScript: delScript
		)
		(if (== gSouth north)
			(gDelph init: y: -70 setMotion: MoveTo 140 80 delScript)
			(gEgo setHeading: 180)
		else
			(gDelph init: y: 250 setMotion: MoveTo 140 120 delScript)
			(gEgo setHeading: 0)
		)
		(global2
			addObstacle:
				((Polygon new:)
					type: 2
					init: 0 189 0 0 16 0 16 189
					yourself:
				)
				((Polygon new:)
					type: 2
					init: 296 189 296 0 319 0 319 189
					yourself:
				)
			setRegions: 51 50
		)
		(super init: &rest)
		((ScriptID 50 0) addFish: @local30 @local14 @local0)
		(gLongSong number: 332 loop: -1 play:)
	)
	
	(method (doit)
		(if (== (self curPic?) 340)
			(Palette palANIMATE 160 207 1)
		)
		(cond 
			(script 0)
			((== (gEgo edgeHit?) 1) (gEgo edgeHit: 0) (global2 setScript: dontGo))
			((== (gEgo edgeHit?) 3) (gDelph setMotion: MoveTo (gEgo x?) 250))
		)
		(super doit:)
	)
)

(instance dontGo of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_1)
				((ScriptID 2 0) init: 1 0 0 5 1 self)
			)
			(1
				(gEgo setMotion: MoveTo (gEgo x?) 30 self)
			)
			(2 (proc0_2) (self dispose:))
		)
	)
)

(instance delScript of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0 0)
			(1 (proc819_9 gDelph gEgo self))
			(2
				(if (== gSouth (global2 north?))
					(self setScript: firstKelpTalk self)
				else
					((ScriptID 2 0) init: 1 0 0 5 1 self)
				)
			)
			(3 (= seconds 6))
			(4
				(proc0_1)
				((ScriptID 2 0) init: 1 0 0 4 1 self)
			)
			(5
				(gEgo setMotion: MoveTo (gEgo x?) 200 self)
				(gDelph setMotion: MoveTo (gDelph x?) 250)
			)
			(6
				(global2 newRoom: (global2 south?))
				(self dispose:)
			)
		)
	)
)

(instance firstKelpTalk of HandsOffScript
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 2 0) init: 1 0 0 1 1 self)
			)
			(1
				((ScriptID 2 1) init: 2 0 0 1 1 self)
			)
			(2 (= cycles 30))
			(3
				((ScriptID 2 0) init: 1 0 0 2 1 self)
			)
			(4 (= cycles 30))
			(5
				((ScriptID 2 1) init: 2 0 0 2 1 self)
			)
			(6
				((ScriptID 2 0) init: 1 0 0 3 1 self)
			)
			(7 (= cycles 30))
			(8
				((ScriptID 2 1) init: 2 0 0 3 1 self)
			)
			(9 (self dispose:))
		)
	)
)
