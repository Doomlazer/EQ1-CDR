;;; Sierra Script 1.0 - (do not remove this comment)
(script# 808)
(include sci.sh)
(use Main)
(use DIcon)
(use RTRandCycle)
(use PolyPath)
(use Cycle)
(use Game)
(use User)
(use Obj)

(public
	eRS 0
)

(procedure (localproc_0498)
	(cond 
		((< (gEgo x?) 0) (gEgo x: (+ 0 (* (gEgo xStep?) 2))))
		((> (gEgo x?) 319) (gEgo x: (- 319 (* (gEgo xStep?) 2))))
	)
)

(procedure (localproc_04de)
	(cond 
		((< (gEgo y?) (global2 horizon?)) (gEgo y: (+ (global2 horizon?) (* (gEgo yStep?) 2))))
		((> (gEgo y?) 189) (gEgo y: (- 189 (* (gEgo yStep?) 2))))
	)
)

(instance controls of Controls
	(properties)
)

(class EcoRoom of Rm
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
		walkOffTop 0
		lookStr 0
	)
	
	(method (init &tmp temp0 temp1 temp2)
		(= number gNumber)
		(= controls controls)
		(= temp2 0)
		(= gPicAngle picAngle)
		(if
		(and (< global87 1) (>= 43 style) (>= style 40))
			(= temp2 1)
			(= style
				(switch style
					(12 3)
					(11 2)
					(13 5)
					(14 4)
				))
		)
		(if picture (self drawPic: picture))
		(cond 
			((not (gCast contains: gEgo)) 0)
			(script 0)
			((or temp2 (proc999_5 style 11 12 13 14))
				(proc0_2)
				(= temp0
					(+
						1
						(/
							(CelWide
								((User alterEgo?) view?)
								((User alterEgo?) loop?)
								((User alterEgo?) cel?)
							)
							2
						)
					)
				)
				(= temp1
					(+
						1
						(CelHigh
							((User alterEgo?) view?)
							((User alterEgo?) loop?)
							((User alterEgo?) cel?)
						)
					)
				)
				(switch ((User alterEgo?) edgeHit?)
					(1 ((User alterEgo?) y: 188))
					(4
						((User alterEgo?) x: (- 319 temp0))
					)
					(3
						((User alterEgo?) y: (- (+ horizon temp1) 5))
					)
					(2
						((User alterEgo?) x: (+ 0 temp0))
					)
				)
				((User alterEgo?) edgeHit: 0)
			)
			(else (self setScript: eRS))
		)
	)
	
	(method (doit &tmp temp0)
		(cond 
			(script (script doit:))
			((not (gCast contains: gEgo)) 0)
			(
				(= temp0
					(switch ((User alterEgo?) edgeHit?)
						(1 north)
						(2 east)
						(3 south)
						(4 west)
					)
				)
				(self setScript: lRS 0 temp0)
			)
		)
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(1
				(if lookStr
					(if (> lookStr 99)
						(EcoNarrator
							init: (+ global250 1) 0 0 (- lookStr 100) 0 gNumber
						)
					else
						(EcoNarrator init: global250 0 0 lookStr 0 gNumber)
					)
				)
			)
			(6
				(EcoNarrator init: 2 0 0 (Random 21 24) 0 4)
			)
			(2
				(EcoNarrator init: 2 0 0 (Random 30 34) 0 4)
			)
			(4
				(EcoNarrator init: 2 0 0 (Random 25 29) 0 4)
			)
			(else 
				(EcoNarrator init: 2 0 0 (Random 35 39) 0 4)
			)
		)
	)
	
	(method (newRoom)
		(proc0_1)
		(super newRoom: &rest)
	)
)

(instance lRS of Script
	(properties)
	
	(method (dispose)
		(gEgo ignoreActors: 0)
		(super dispose:)
	)
	
	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(proc0_1)
				(gEgo ignoreActors: 1)
				(= temp1 35)
				(switch register
					((client north?)
						(if (client walkOffTop?)
							(gEgo
								ignoreHorizon: 1
								setMotion:
									PolyPath
									(gEgo x?)
									(- 0 (- (gEgo nsBottom?) (- (gEgo y?) (gEgo z?))))
									self
							)
						else
							(global2 newRoom: register)
						)
					)
					((client south?)
						(= temp0
							(CelHigh (gEgo view?) (gEgo loop?) (gEgo cel?))
						)
						(gEgo setMotion: PolyPath (gEgo x?) (+ 189 temp0) self)
					)
					((client east?)
						(gEgo setMotion: PolyPath (+ 319 temp1) (gEgo y?) self)
					)
					((client west?)
						(gEgo setMotion: PolyPath (- 0 temp1) (gEgo y?) self)
					)
				)
			)
			(1 (gEgo hide:) (= cycles 1))
			(2
				(global2 setScript: 0 newRoom: register)
			)
		)
	)
)

(instance eRS of Script
	(properties)
	
	(method (init)
		(gEgo ignoreActors: 1)
		(super init: &rest)
	)
	
	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(= cycles 0)
				(proc0_1)
				(= temp0
					(CelHigh (gEgo view?) (gEgo loop?) (gEgo cel?))
				)
				(= temp1 25)
				(switch gSouth
					((client north?)
						(localproc_0498)
						(gEgo y: (+ (global2 horizon?) (gEgo yStep?)))
						(= cycles 1)
					)
					((client south?)
						(localproc_0498)
						(gEgo
							y: (+ 189 temp0)
							setMotion: nBMT (gEgo x?) (- 189 (* (gEgo yStep?) 2)) self
						)
					)
					((client east?)
						(localproc_04de)
						(gEgo
							x: (+ 319 (/ temp1 2))
							setMotion: nBMT (- 319 (* (gEgo xStep?) 2)) (gEgo y?) self
						)
					)
					((client west?)
						(localproc_04de)
						(gEgo
							x: (- 0 (/ temp1 2))
							setMotion: nBMT (+ 0 (* (gEgo xStep?) 2)) (gEgo y?) self
						)
					)
					(else  (= cycles 1))
				)
			)
			(1
				(proc0_2)
				(gEgo ignoreActors: 0)
				(client notify:)
				(self dispose:)
			)
		)
	)
)

(instance nBMT of MoveTo
	(properties)
	
	(method (doit)
		(super doit:)
		(if (client isBlocked:) (self moveDone:))
	)
)
